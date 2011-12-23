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
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.openappengine.facade.ui.common.EntityReference;
import com.openappengine.facade.ui.common.EntityReference.IncludeFields;
import com.openappengine.facade.ui.form.FieldLayout;
import com.openappengine.facade.ui.screen.Screen;
import com.openappengine.facade.ui.widgets.Widget;
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

									// EntityReference Object
									Element entityRefElement = DomUtils
											.getChildElementByTagName(widgetElement, "entity-ref");
									if (entityRefElement != null) {
										String entityName = entityRefElement.getAttribute("entity-name");
										if (StringUtils.isEmpty(entityName)) {
											throw new RuntimeException("Entity Name cannot be empty.");
										}

										EntityReference entityRef = new EntityReference(entityName);
										String includeFields = entityRefElement.getAttribute("include-fields");
										if (StringUtils.isEmpty(includeFields)) {
											includeFields = "auto";
										}
										// TODO validate if include-fields attr
										// and
										// handle the IncludeFields is supported
										// by
										// EntityReference class.
										entityRef.setIncludeFields(IncludeFields.AUTO);

										form.setEntityReference(entityRef);
									} else {
										// TODO - Has to be a service-ref
										// element !
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
												// TODO - Check Default
												// settings.
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
