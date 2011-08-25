/**
 * 
 */
package com.ms.openapps.oxm;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.ms.openapps.util.UtilXml;

/**
 * @author hrishi
 * 
 */
public class OxmMapper implements IOxmMapper {

	private Marshaller marshaller;

	private Unmarshaller unmarshaller;

	@Override
	public Document marshalObject(Object object) throws OxmMappingException {
		String resultXml = new String();
		StringWriter writer = new StringWriter();
		Document xmlDocument = null;
		try {
			// Marshal the object to String Xml
			marshaller.marshal(object, new StreamResult(writer));

			resultXml = writer.toString();
			xmlDocument = UtilXml.readXmlDocument(resultXml);

		} catch (XmlMappingException e) {
			throw new OxmMappingException(
					"XmlMappingException enountered while Marshalling object");
		} catch (IOException e) {
			throw new OxmMappingException(
					"IOException enountered while Marshalling object");
		} catch (SAXException e) {
			throw new OxmMappingException(
					"SAXException enountered while Marshalling object");
		} catch (ParserConfigurationException e) {
			throw new OxmMappingException(
					"ParserConfigurationException enountered while Marshalling object");
		}
		return xmlDocument;
	}

	@Override
	public Object unmarshal(Document document) throws OxmMappingException {
		Object resultObj = null;
		try {
			DOMSource domSource = new DOMSource(document);
			resultObj = unmarshaller.unmarshal(domSource);
		} catch (XmlMappingException e) {
			throw new OxmMappingException(
					"XmlMappingException enountered while Marshalling object");
		} catch (IOException e) {
			throw new OxmMappingException(
					"IOException enountered while Marshalling object");
		}
		return resultObj;
	}

	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	public Marshaller getMarshaller() {
		return marshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	public Unmarshaller getUnmarshaller() {
		return unmarshaller;
	}

	@Override
	public Object unmarshal(InputStream fis) throws OxmMappingException {
		Object unmarshal = null;
		try {
			unmarshal = unmarshaller.unmarshal(new StreamSource(fis));
		} catch (XmlMappingException e) {
			e.printStackTrace();
			throw new OxmMappingException(
					"XmlMappingException enountered while Marshalling object");
		} catch (IOException e) {
			throw new OxmMappingException(
					"IOException enountered while Marshalling object");
		}
		return unmarshal;
	}

}
