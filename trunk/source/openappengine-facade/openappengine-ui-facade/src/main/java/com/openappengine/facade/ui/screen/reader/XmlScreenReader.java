/**
 * 
 */
package com.openappengine.facade.ui.screen.reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.openappengine.facade.entity.EntityFacade;
import com.openappengine.facade.entity.context.EntityFacadeContext;
import com.openappengine.facade.entity.definition.EntityDefinition;
import com.openappengine.facade.entity.definition.FieldDefinition;
import com.openappengine.facade.ui.action.PreActionHandler;
import com.openappengine.facade.ui.action.entity.EntityFindOneAction;
import com.openappengine.facade.ui.common.EntityReference;
import com.openappengine.facade.ui.common.EntityReference.IncludeFields;
import com.openappengine.facade.ui.form.FieldLayout;
import com.openappengine.facade.ui.params.Param;
import com.openappengine.facade.ui.params.Parameters;
import com.openappengine.facade.ui.params.Value;
import com.openappengine.facade.ui.resolver.ScreenContextVariableResolver;
import com.openappengine.facade.ui.resolver.ValueResolver;
import com.openappengine.facade.ui.screen.Screen;
import com.openappengine.facade.ui.widgets.container.Container;
import com.openappengine.facade.ui.widgets.container.ContainerPanel;
import com.openappengine.facade.ui.widgets.forms.Form;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishikesh.joshi
 * @Dec 22, 2011
 */
public class XmlScreenReader {

	private final Logger logger = Logger.getLogger(getClass());
	
	private final EntityFacade entityFacade = EntityFacadeContext.getEntityFacade();

	public XmlScreenReader() {
	}

	public Screen readScreenDefinition(InputStream inputStream) {
		Validate.notNull(inputStream, "No Screen Definition found at the given input stream.");
		Screen screen = new Screen();

		try {
			Document document = UtilXml.readXmlDocument(inputStream);
			if (document == null) {
				logger.error("No Screen Definition Found !");
				return null;
			}

			Element documentElement = document.getDocumentElement();
			if (documentElement == null) {
				logger.error("Document Element returned null !");
				return null;
			}

			if (!StringUtils.equals(documentElement.getNodeName(), "screen")) {
				logger.error("Parent Node should be <screen> !");
				return null;
			}

			documentElement.normalize();
			
			//TODO Read Actions
			//Read Params Tag.
			Element paramsElement = DomUtils.getChildElementByTagName(documentElement, "parameter");
			if(paramsElement != null) {
				Parameters parameters = new Parameters();
				List<Element> paramElements = DomUtils.getChildElements(paramsElement);
				if(paramElements != null) {
					for (Element paramElement : paramElements) {
						String name = paramElement.getAttribute("name");
						if(StringUtils.isEmpty(name)) {
							//TODO - Throw Exception
						}
						
						String required = paramElement.getAttribute("required");
						boolean isRequired = false;
						if(!StringUtils.isEmpty(required)) {
							isRequired = Boolean.valueOf(required);
						}
						
						String valueRef = paramElement.getAttribute("value-ref");
						if(StringUtils.isEmpty(valueRef)) {
							//TODO - Throw Exception
						}
						
						Param param = new Param(name,isRequired,valueRef);
						parameters.setParam(param, null);
					}
				}
 				screen.setScreenParameters(parameters);
			}
			
			Element preActionElements = DomUtils.getChildElementByTagName(documentElement, "pre-actions");
			PreActionHandler preActionHandler = new PreActionHandler();
			if(preActionElements != null) {
				//Handle entity-find-one tags.
				List<Element> entityFindOneElements = DomUtils.getChildElementsByTagName(preActionElements, "entity-find-one");
				if(entityFindOneElements != null && !entityFindOneElements.isEmpty()) {
					for (Element entityFindOneElement : entityFindOneElements) {
						//Scan Each Find One Element
						String attrFindOneEntityName = entityFindOneElement.getAttribute("entity-name");
						EntityFindOneAction entityFindOneAction = new EntityFindOneAction(attrFindOneEntityName);
						
						if(StringUtils.isEmpty(attrFindOneEntityName)) {
							throw new RuntimeException("entity-name is a required attribute for action : <entity-find-one> ");
						}
						
						
						String attrValueField = entityFindOneElement.getAttribute("value-field");
						if(StringUtils.isEmpty(attrValueField)) {
							throw new RuntimeException("value-field is a required attribute for action : <entity-find-one> ");
						}
						entityFindOneAction.setValueField(attrValueField);
						
						String attrAutoFieldMap = entityFindOneElement.getAttribute("auto-field-map");
						boolean autoFieldMap = false;
						if(StringUtils.isEmpty(attrAutoFieldMap)) {
							autoFieldMap = false;
						} else {
							autoFieldMap = Boolean.valueOf(attrAutoFieldMap);
						}
						
						entityFindOneAction.setAutoFieldMap(autoFieldMap);
						
						if(!autoFieldMap) {
							List<Element> fieldMaps = DomUtils.getChildElementsByTagName(entityFindOneElement, "field-map");
							if(fieldMaps != null && !fieldMaps.isEmpty()) {
								for (Element fieldMap : fieldMaps) {
									String fieldName = fieldMap.getAttribute("field-name");
									String valueRef = fieldMap.getAttribute("value-ref");
									//TODO - We can also have a value and a value-ref
									ScreenContextVariableResolver valueResolver = new ScreenContextVariableResolver(valueRef);
									entityFindOneAction.addAndParameter(fieldName, new Value(valueResolver));
								}
							}
						} else {
							//Since auto-field-map = false; get the pk-fields for this entity and resolve them from the screen context.
							EntityDefinition entityDefinition = entityFacade.findEntityDefinition(attrFindOneEntityName);
							Assert.notNull(entityDefinition,"Entity Definition not found for " + attrFindOneEntityName);
							List<FieldDefinition> pkFields = entityDefinition.getPKFields();
							for (FieldDefinition pkField : pkFields) {
								String fieldName = pkField.getName();
								ScreenContextVariableResolver valueResolver = new ScreenContextVariableResolver(fieldName);
								entityFindOneAction.addAndParameter(fieldName, new Value(valueResolver));
							}
						}
						preActionHandler.addPreAction(entityFindOneAction);
					}
				}
				//Handle entity-find-one tags.
			}
			
			screen.setPreActionHandler(preActionHandler);

			// Read Container-Panel Element
			Element containerPanelElement = DomUtils.getChildElementByTagName(documentElement, "container-panel");
			if (containerPanelElement == null) {
				logger.error("One <container-panel> tag element required.");
				return null;
			} else {
				
				ContainerPanel containerPanel = new ContainerPanel();
				
				// Center-Panel
				Element centerContainerElement = DomUtils.getChildElementByTagName(containerPanelElement, "center-panel");
				if (centerContainerElement != null) {
					Container centerContainer = new Container();

					// Container Id
					String attrId = centerContainerElement.getAttribute("id");
					if (!StringUtils.isEmpty(attrId)) {
						centerContainer.setId(attrId);
					}

					Element widgetsElement = DomUtils.getChildElementByTagName(centerContainerElement, "widgets");
					if (widgetsElement != null) {
						List<Element> widgetElements = DomUtils.getChildElements(widgetsElement);

						if (widgetElements != null) {

							for (Element widgetElement : widgetElements) {
								
								// Read Form Element
								if (DomUtils.nodeNameEquals(widgetElement, "form")) {
									// TODO - Call a Form Xml Reader element here.
									Form form = new Form();
									form.setParentScreen(screen);
									
									String attrValueRef = widgetElement.getAttribute("entity-value-ref");
									if(StringUtils.isEmpty(attrValueRef)) {
										//If entity-value-ref is specified. This indicates that it 
										Element entityRefElement = DomUtils.getChildElementByTagName(widgetElement, "entity-ref");
										if (entityRefElement != null) {
											String entityName = entityRefElement.getAttribute("entity-name");
											if (StringUtils.isEmpty(entityName)) {
												throw new RuntimeException("Entity Name cannot be empty.");
											}
											
											EntityReference entityRef = new EntityReference(entityName);
											String includeFields = entityRefElement.getAttribute("include-fields");
											if (StringUtils.isEmpty(includeFields)) {
												includeFields = "auto";
												entityRef.setIncludeFields(IncludeFields.AUTO);
											}
											// TODO validate if include-fields attr and handle the IncludeFields is supported 
											// by EntityReference class.
											
											form.setEntityReference(entityRef);
										} else {
											// TODO - Has to be a service-ref element !
											throw new UnsupportedOperationException("<form> element should have an entity-value-ref attribute or <entity-ref> sub-element.");
										}
									} else {
										//TODO - entity-value-ref is specified. So resolve the entity value from the context.
										/*String attrEntityName = widgetElement.getAttribute("entity-name");
										ValueResolver valueResolver = new ScreenContextVariableResolver(attrValueRef);
										if(StringUtils.isEmpty(attrEntityName)) {
											throw new RuntimeException("Either an entity-value-ref or an entity-name element should be given to the form element");
										} else {
											//TODO - When entity-name is set, load the entity based upon the pre-actions. 
											form.setEntityName(attrEntityName);
										}*/
										form.setEntityValueRef(attrValueRef);
									}

									Element fieldLayoutElement = DomUtils.getChildElementByTagName(widgetElement,
											"field-layout");
									FieldLayout fieldLayout = new FieldLayout();
									if (fieldLayoutElement != null) {
										Element columnElement = DomUtils.getChildElementByTagName(fieldLayoutElement,
												"column");
										if (columnElement != null) {
											String columns = DomUtils.getTextValue(columnElement);
											Integer col = Integer.valueOf(columns);
											if (col == null) {
												// TODO - Check Default settings.
												fieldLayout.setColumns(2);
											} else {
												fieldLayout.setColumns(col);
											}
										}
										// TODO - Handle referenced-fields.
									} else {
										// TODO - Check Default settings.
										fieldLayout.setColumns(2);
										if (form.getEntityReference().getIncludeFields() != IncludeFields.AUTO) {
											throw new RuntimeException(
													"If include-fields = auto, then field-layout should be specified.");
										}
									}
									form.setFieldLayout(fieldLayout);
									
									// Add form to the center container.
									screen.setContainerPanel(containerPanel);
									centerContainer.addWidget(form);
									containerPanel.setCenterPanel(centerContainer);
									
									//Add Widget to the main screen.
									//TODO - Handle in the individual Widget API Class.
									screen.addWidget(attrId, form);
								}

								// TODO Other Widgets.
							}
						}
					}
				}
			}

		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return screen;
	}

}
