/**
 * 
 */
package com.openappengine.gui.engine.context.factory;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.openappengine.utility.UtilXml;

/**
 * @author hrishikesh.joshi
 * @Dec 22, 2011
 */
public class DefaultGuiDefinitionReader extends AbstractGuiDefinitionReader {

	private GuiContextFactory factory;
	
	public DefaultGuiDefinitionReader(GuiContextFactory factory) {
		super();
		this.setFactory(factory);
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

}
