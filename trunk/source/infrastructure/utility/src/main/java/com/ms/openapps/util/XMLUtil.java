package com.ms.openapps.util;
import static com.ms.openapps.util.XMLTagLibrary.XML_ERROR;
import static com.ms.openapps.util.XMLTagLibrary.XML_ERROR_MESSAGE;
import static com.ms.openapps.util.XMLTagLibrary.XML_ERROR_PATH;
import static com.ms.openapps.util.XMLTagLibrary.XML_ERROR_SEVERITY;
import static com.ms.openapps.util.XMLTagLibrary.XML_ROOT;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
/**
 * @author hrishi
 *
 */
public class XMLUtil {
    
	private static Node getNodeAtPath(Node document,String path)
    {
		Node node = document.selectSingleNode(path);
		return node;
    }
    
    public static Node getPathedElement(Node document,String path){
		Node node = getNodeAtPath(document, path);
		return node;
    }
    
    public static Node setPathedElement(Node node,String pathfromNode,String text)
    {
    	Node path = node.selectSingleNode(pathfromNode);
    	
    	if(path!=null)
    		 path.setText(text);
    	
    	return node; 
    }
    
    public static int getIntPathedElement(Document document,String path,int errorValue)
    {
    	return errorValue;
    }
    
    public static Element initDocument(String rootName)
    {
    	Document document = DocumentHelper.createDocument();
    	Element root = document.addElement(rootName);
    	return root;
    }
    
    public static void addElement(Element parent,String elementToAdd,String value)
    {
    	Element child = parent.addElement(elementToAdd);
    	child.setText(value);
    }
    
    public static Node isErrorNode(Document document)
    {
    	Node error = document.selectSingleNode(XML_ERROR_PATH);
    	return error;
    }
    
    public static Document addErrorElement(Document document,String severity,String message)
    {
    	Element error = (Element) isErrorNode(document);
    	
    	if(error == null)
    	{
    		Element rootEle = (Element) document.selectSingleNode(XML_ROOT);
    		error = rootEle.addElement(XML_ERROR);
    	}
    		
	    	Element severityEl = error.addElement(XML_ERROR_SEVERITY);
	    	severityEl.setText(severity);
	    	
	    	Element messageEl = error.addElement(XML_ERROR_MESSAGE);
	    	messageEl.setText(message);
    	
    	return document;    	
    }

	public static org.w3c.dom.Document readXML(String xmlString) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    factory.setNamespaceAware(true);
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    return builder.parse(new ByteArrayInputStream(xmlString.getBytes()));
	}

	  public static String writeXMLtoString(org.w3c.dom.Document doc) throws Exception{
		  TransformerFactory transfac = TransformerFactory.newInstance();
          Transformer trans = transfac.newTransformer();

          StringWriter sw = new StringWriter();
          StreamResult result = new StreamResult(sw);
          DOMSource source = new DOMSource(doc);
          trans.transform(source, result);
          String xmlString = sw.toString();
          
          return xmlString;
	  }
}
