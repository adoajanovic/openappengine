/**
 * 
 */
package com.openappengine.facade.context.factory;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.openappengine.facade.context.factory.xml.DefaultScreenDefinitionDocumentReader;
import com.openappengine.facade.context.factory.xml.ScreenDefinitionDocumentReader;
import com.openappengine.facade.core.executor.action.entity.EntityFindOneAction;
import com.openappengine.facade.ui.screen.Screen;

/**
 * @author hrishikesh.joshi
 * @Dec 22, 2011
 */
public class XmlScreenDefinitionReader extends AbstractScreenDefinitionReader {

	private ScreenApplicationContextFactory factory;
	
	private ScreenDefinitionDocumentReader documentReader;

	public XmlScreenDefinitionReader(ScreenApplicationContextFactory factory) {
		super();
		this.setFactory(factory);
		
		createDocumentReader();
	}

	private void createDocumentReader() {
		documentReader = new DefaultScreenDefinitionDocumentReader();
	}

	//TODO - Remove !!
	public Screen readScreenDefinition(InputStream inputStream) {
		return null;
	}

	//TODO - Remove !!
	protected EntityFindOneAction processEntityFindOneActionTag(Element entityFindOneElement) {
		return null;
	}

	@Override
	public void loadScreenDefinition(Resource resource) {
		Assert.notNull(resource,"Resource cannot be null.");
		try {
			InputStream inputStream = resource.getInputStream();
			loadScreenDefinition(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void loadScreenDefinition(InputStream inputStream) {
		try {
			DocumentBuilder builder = createDocumentBuilder();
			Document doc = builder.parse(inputStream);
			getDocumentReader().registerScreenDefinition(doc);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public ScreenApplicationContextFactory getFactory() {
		return factory;
	}

	public void setFactory(ScreenApplicationContextFactory factory) {
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
