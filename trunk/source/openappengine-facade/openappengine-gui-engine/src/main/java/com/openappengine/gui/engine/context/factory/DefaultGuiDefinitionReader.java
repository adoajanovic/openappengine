/**
 * 
 */
package com.openappengine.gui.engine.context.factory;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.openappengine.gui.engine.context.factory.xml.DefaultScreenDefinitionDocumentReader;
import com.openappengine.gui.engine.context.factory.xml.ScreenDefinitionDocumentReader;
import com.openappengine.gui.engine.core.component.ui.GuiRootComponent;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishikesh.joshi
 * @Dec 22, 2011
 */
public class DefaultGuiDefinitionReader extends AbstractGuiDefinitionReader {

	private GuiContextFactory factory;
	
	private ScreenDefinitionDocumentReader documentReader;

	public DefaultGuiDefinitionReader(GuiContextFactory factory) {
		super();
		this.setFactory(factory);
		
		createDocumentReader();
	}

	private void createDocumentReader() {
		documentReader = new DefaultScreenDefinitionDocumentReader();
	}

	@Override
	public GuiRootComponent loadScreenDefinition(Resource resource) {
		Assert.notNull(resource,"Resource cannot be null.");
		try {
			InputStream inputStream = resource.getInputStream();
			return loadScreenDefinition(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Document getScreenXmlDocument(Resource resource) {
		try {
			Document document = UtilXml.readXmlDocument(resource.getInputStream());
			return document;
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected GuiRootComponent loadScreenDefinition(InputStream inputStream) {
		try {
			DocumentBuilder builder = createDocumentBuilder();
			Document doc = builder.parse(inputStream);
			GuiRootComponent uiRoot = getDocumentReader().readUIRootDefinition(doc);
			return uiRoot;
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public GuiContextFactory getFactory() {
		return factory;
	}

	public void setFactory(GuiContextFactory factory) {
		this.factory = factory;
	}

	private DocumentBuilder createDocumentBuilder() throws ParserConfigurationException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		builderFactory.setValidating(true);
		builderFactory.setNamespaceAware(false);
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		return builder;
	}

	protected ScreenDefinitionDocumentReader getDocumentReader() {
		return documentReader;
	}

	public void setDocumentReader(ScreenDefinitionDocumentReader reader) {
		this.documentReader = reader;
	}

}
