package com.openappengine.utility;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import javolution.util.FastList;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.org.apache.xpath.internal.jaxp.XPathFactoryImpl;

/**
 * Utilities methods to simplify dealing with JAXP & DOM XML parsing
 *
 */
public class UtilXml {

    public static final String module = UtilXml.class.getName();

    public static String writeXmlDocument(Document document) {
        if (document == null) {
            return null;
        }
        String xmlDocument = "";
        try {
			xmlDocument = writeXmlDocument(document.getDocumentElement());
		} catch (IOException e) {
		}
        return xmlDocument;
    }

    public static String writeXmlDocument(Element element) throws java.io.IOException {
        if (element == null) {
            return null;
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        writeXmlDocument(bos, element);
        String outString = bos.toString("UTF-8");

        if (bos != null) bos.close();
        return outString;
    }

    public static String writeXmlDocument(DocumentFragment fragment) throws java.io.IOException {
        if (fragment == null) {
            return null;
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        List<? extends Element> elementList = UtilXml.childElementList(fragment);
        for (Element element: elementList) {
            writeXmlDocument(bos, element);
        }
        String outString = bos.toString("UTF-8");

        if (bos != null) bos.close();
        return outString;
    }

    public static void writeXmlDocument(String filename, Document document)
        throws java.io.FileNotFoundException, java.io.IOException {
        if (document == null) {
            return;
        }
        writeXmlDocument(filename, document.getDocumentElement());
    }

    public static void writeXmlDocument(String filename, Element element)
        throws java.io.FileNotFoundException, java.io.IOException {
        if (element == null) {
            return;
        }
        if (filename == null) {
            return;
        }

        File outFile = new File(filename);
        FileOutputStream fos = null;
        fos = new FileOutputStream(outFile);

        try {
            writeXmlDocument(fos, element);
        } finally {
            if (fos != null) fos.close();
        }
    }

    public static void writeXmlDocument(OutputStream os, Document document) throws java.io.IOException {
        if (document == null) {
            return;
        }
        writeXmlDocument(os, document.getDocumentElement());
    }
    public static void writeXmlDocument(OutputStream os, Element element) throws java.io.IOException {
        OutputFormat format = new OutputFormat(element.getOwnerDocument());
        writeXmlDocument(os, element, format);
    }

    public static void writeXmlDocument(OutputStream os, Element element, OutputFormat format) throws java.io.IOException {
        if (element == null) {
            return;
        }
        if (os == null) {
            return;
        }

        XMLSerializer serializer = new XMLSerializer(os, format);
        serializer.asDOMSerializer();
        serializer.serialize(element);
    }

    public static Document readXmlDocument(String content)
            throws SAXException, ParserConfigurationException, java.io.IOException {
        return readXmlDocument(content, true);
    }

    public static Document readXmlDocument(String content, boolean validate)
            throws SAXException, ParserConfigurationException, java.io.IOException {
        if (content == null) {
            return null;
        }
        ByteArrayInputStream bis = new ByteArrayInputStream(content.getBytes("UTF-8"));
        return readXmlDocument(bis, validate, "Internal Content");
    }

    public static Document readXmlDocument(URL url)
            throws SAXException, ParserConfigurationException, java.io.IOException {
        return readXmlDocument(url, true);
    }

    public static Document readXmlDocument(URL url, boolean validate)
            throws SAXException, ParserConfigurationException, java.io.IOException {
        if (url == null) {
            return null;
        }
        return readXmlDocument(url.openStream(), validate, url.toString());
    }

    public static Document readXmlDocument(InputStream is)
            throws SAXException, ParserConfigurationException, java.io.IOException {
        return readXmlDocument(is, true, null);
    }

    public static Document readXmlDocument(InputStream is, String docDescription)
            throws SAXException, ParserConfigurationException, java.io.IOException {
        return readXmlDocument(is, true, docDescription);
    }

    public static Document readXmlDocument(InputStream is, boolean validate, String docDescription)
            throws SAXException, ParserConfigurationException, java.io.IOException {
        if (is == null) {
            return null;
        }

        long startTime = System.currentTimeMillis();

        // DON'T do this: seems to be causing problems with Catalina/Tomcat, maybe it is expecting a different parser?
        //System.setProperty("javax.xml.parsers.DocumentBuilderFactory", "org.apache.xerces.jaxp.DocumentBuilderFactoryImpl");

        Document document = null;

        /* Xerces DOMParser direct interaction; the other seems to be working better than this, so we'll stay with the standard JAXP stuff
        DOMParser parser = new DOMParser();
        try {
            parser.setFeature("http://xml.org/sax/features/validation", true);
            parser.setFeature("http://apache.org/xml/features/validation/schema", true);
        } catch (SAXException e) {
            Debug.logWarning("Could not set parser feature: " + e.toString(), module);
        }
        parser.parse(new InputSource(is));
        document = parser.getDocument();
        */

        /* Standard JAXP (mostly), but doesn't seem to be doing XML Schema validation, so making sure that is on... */
        DocumentBuilderFactory factory = new org.apache.xerces.jaxp.DocumentBuilderFactoryImpl();
        factory.setValidating(validate);
        factory.setNamespaceAware(true);

        factory.setAttribute("http://xml.org/sax/features/validation", validate);
        factory.setAttribute("http://apache.org/xml/features/validation/schema", validate);

        // with a SchemaUrl, a URL object
        //factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
        //factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource", SchemaUrl);
        DocumentBuilder builder = factory.newDocumentBuilder();
        if (validate) {
        	//TODO
/*            LocalResolver lr = new LocalResolver(new DefaultHandler());
            ErrorHandler eh = new LocalErrorHandler(docDescription, lr);

            builder.setEntityResolver(lr);
            builder.setErrorHandler(eh);*/
        }
        document = builder.parse(is);

        double totalSeconds = (System.currentTimeMillis() - startTime)/1000.0;
        return document;
    }
    
    public static Node evaluateXPathNode(Node node,String xpathExpression) {
    	try {
    		XPathFactory xPathFactory = XPathFactoryImpl.newInstance();
    		XPath xPath = xPathFactory.newXPath();
    		XPathExpression pathExpression = xPath.compile(xpathExpression);
    		Object evaluate = pathExpression.evaluate(node, XPathConstants.NODE);
    		return (Node) evaluate;
    	} catch (Exception e) {
			// TODO: handle exception
		}
    	return null;
    }
    
    public static NodeList evaluateXPathNodeList(Node node,String xpathExpression) {
    	try {
    		XPathFactory xPathFactory = XPathFactoryImpl.newInstance();
    		XPath xPath = xPathFactory.newXPath();
    		XPathExpression pathExpression = xPath.compile(xpathExpression);
    		Object evaluate = pathExpression.evaluate(node, XPathConstants.NODESET);
    		return (NodeList) evaluate;
    	} catch (Exception e) {
			// TODO: handle exception
		}
    	return null;
    }

    public static Document makeEmptyXmlDocument() {
        return makeEmptyXmlDocument(null);
    }

    public static Document makeEmptyXmlDocument(String rootElementName) {
        Document document = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //factory.setValidating(true);
        // factory.setNamespaceAware(true);
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            document = builder.newDocument();
        } catch (Exception e) {
        	e.printStackTrace();
        }

        if (document == null) return null;

        if (rootElementName != null) {
            Element rootElement = document.createElement(rootElementName);
            document.appendChild(rootElement);
        }

        return document;
    }

    /** Creates a child element with the given name and appends it to the element child node list. */
    public static Element addChildElement(Element parentElement, String childElementName, Document document) {
        Element newElement = document.createElement(childElementName);
        parentElement.appendChild(newElement);
        return newElement;
    }
    
    public static Element updateSingleElement(Element element,String childElementName,String value) {
    	Element firstChildElement = firstChildElement(element,childElementName);
    	if(firstChildElement == null) {
    		firstChildElement = addChildElement(element, childElementName, element.getOwnerDocument());
    	}
    	firstChildElement.setNodeValue(value);
    	return firstChildElement;
    }

    /** Creates a child element with the given name and appends it to the element child node list.
     *  Also creates a Text node with the given value and appends it to the new elements child node list.
     */
    public static Element addChildElementValue(Element element, String childElementName,
            String childElementValue, Document document) {
        Element newElement = addChildElement(element, childElementName, document);

        newElement.appendChild(document.createTextNode(childElementValue));
        return newElement;
    }

    /** Creates a child element with the given name and appends it to the element child node list.
     *  Also creates a CDATASection node with the given value and appends it to the new elements child node list.
     */
    public static Element addChildElementCDATAValue(Element element, String childElementName,
            String childElementValue, Document document) {
        Element newElement = addChildElement(element, childElementName, document);

        newElement.appendChild(document.createCDATASection(childElementValue));
        return newElement;
    }

    /** Return a List of Element objects that are children of the given element */
    public static List<? extends Element> childElementList(Element element) {
        if (element == null) return null;

        List<Element> elements = FastList.newInstance();
        Node node = element.getFirstChild();

        if (node != null) {
            do {
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element childElement = (Element) node;
                    elements.add(childElement);
                }
            } while ((node = node.getNextSibling()) != null);
        }
        return elements;
    }

    /** Return a List of Element objects that have the given name and are
     * immediate children of the given element; if name is null, all child
     * elements will be included. */
    public static List<? extends Element> childElementList(Element element, String childElementName) {
        if (element == null) return null;

        List<Element> elements = FastList.newInstance();
        Node node = element.getFirstChild();

        if (node != null) {
            do {
                if (node.getNodeType() == Node.ELEMENT_NODE && (childElementName == null ||
                        childElementName.equals(node.getNodeName()))) {
                    Element childElement = (Element) node;

                    elements.add(childElement);
                }
            } while ((node = node.getNextSibling()) != null);
        }
        return elements;
    }

    /** Return a List of Element objects that have the given name and are
     * immediate children of the given element; if name is null, all child
     * elements will be included. */
    public static List<? extends Element> childElementList(Element element, Set<String> childElementNames) {
        if (element == null) return null;

        List<Element> elements = FastList.newInstance();
        if (childElementNames == null) return elements;
        Node node = element.getFirstChild();

        if (node != null) {
            do {
                if (node.getNodeType() == Node.ELEMENT_NODE && childElementNames.contains(node.getNodeName())) {
                    Element childElement = (Element) node;
                    elements.add(childElement);
                }
            } while ((node = node.getNextSibling()) != null);
        }
        return elements;
    }

     /** Return a List of Element objects that are children of the given DocumentFragment */
    public static List<? extends Element> childElementList(DocumentFragment fragment) {
        if (fragment == null) return null;
        List<Element> elements = FastList.newInstance();
        Node node = fragment.getFirstChild();
        if (node != null) {
            do {
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element childElement = (Element) node;
                    elements.add(childElement);
                }
            } while ((node = node.getNextSibling()) != null);
        }
        return elements;
    }

    /** Return a List of Node objects that have the given name and are immediate children of the given element;
      * if name is null, all child elements will be included. */
    public static List<? extends Node> childNodeList(Node node) {
        if (node == null) return null;

        List<Node> nodes = FastList.newInstance();

        if (node != null) {
            do {
                if (node.getNodeType() == Node.ELEMENT_NODE || node.getNodeType() == Node.COMMENT_NODE) {
                    nodes.add(node);
                }
            } while ((node = node.getNextSibling()) != null);
        }
        return nodes;
    }

    /** Return the first child Element
     * returns the first element. */
    public static Element firstChildElement(Element element, Set<String> childElementNames) {
        if (element == null) return null;
        // get the first element with the given name
        Node node = element.getFirstChild();

        if (node != null) {
            do {
                if (node.getNodeType() == Node.ELEMENT_NODE && childElementNames.contains(node.getNodeName())) {
                    Element childElement = (Element) node;

                    return childElement;
                }
            } while ((node = node.getNextSibling()) != null);
        }
        return null;
    }

      /** Return the first child Element
     * returns the first element. */
    public static Element firstChildElement(Element element) {
        if (element == null) return null;
        // get the first element with the given name
        Node node = element.getFirstChild();

        if (node != null) {
            do {
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element childElement = (Element) node;

                    return childElement;
                }
            } while ((node = node.getNextSibling()) != null);
        }
        return null;
    }

    /** Return the first child Element with the given name; if name is null
     * returns the first element. */
    public static Element firstChildElement(Element element, String childElementName) {
        if (element == null) return null;
        if (UtilValidate.isEmpty(childElementName)) return null;
        // get the first element with the given name
        Node node = element.getFirstChild();

        if (node != null) {
            do {
                if (node.getNodeType() == Node.ELEMENT_NODE && (childElementName == null ||
                        childElementName.equals(node.getNodeName()))) {
                    Element childElement = (Element) node;
                    return childElement;
                }
            } while ((node = node.getNextSibling()) != null);
        }
        return null;
    }

    /** Return the first child Element with the given name; if name is null
     * returns the first element. */
    public static Element firstChildElement(Element element, String childElementName, String attrName, String attrValue) {
        if (element == null) return null;
        // get the first element with the given name
        Node node = element.getFirstChild();

        if (node != null) {
            do {
                if (node.getNodeType() == Node.ELEMENT_NODE && (childElementName == null ||
                        childElementName.equals(node.getNodeName()))) {
                    Element childElement = (Element) node;

                    String value = childElement.getAttribute(attrName);

                    if (value != null && value.equals(attrValue)) {
                        return childElement;
                    }
                }
            } while ((node = node.getNextSibling()) != null);
        }
        return null;
    }

    /** Return the text (node value) contained by the named child node. */
    public static String childElementValue(Element element, String childElementName) {
        if (element == null) return null;
        // get the value of the first element with the given name
        Element childElement = firstChildElement(element, childElementName);

        return elementValue(childElement);
    }

    /** Return the text (node value) contained by the named child node or a default value if null. */
    public static String childElementValue(Element element, String childElementName, String defaultValue) {
        if (element == null) return defaultValue;
        // get the value of the first element with the given name
        Element childElement = firstChildElement(element, childElementName);
        String elementValue = elementValue(childElement);

        if (elementValue == null || elementValue.length() == 0)
            return defaultValue;
        else
            return elementValue;
    }

    /** Return the text (node value) of the first node under this, works best if normalized. */
    public static String elementValue(Element element) {
        if (element == null) return null;
        // make sure we get all the text there...
        element.normalize();
        Node textNode = element.getFirstChild();

        if (textNode == null) return null;

        StringBuilder valueBuffer = new StringBuilder();
        do {
            if (textNode.getNodeType() == Node.CDATA_SECTION_NODE || textNode.getNodeType() == Node.TEXT_NODE) {
                valueBuffer.append(textNode.getNodeValue());
            }
        } while ((textNode = textNode.getNextSibling()) != null);
        return valueBuffer.toString();
    }

    /** Return the text (node value) of the first node under this */
    public static String nodeValue(Node node) {
        if (node == null) return null;

        StringBuilder valueBuffer = new StringBuilder();
        do {
            if (node.getNodeType() == Node.CDATA_SECTION_NODE || node.getNodeType() == Node.TEXT_NODE || node.getNodeType() == Node.COMMENT_NODE) {
                valueBuffer.append(node.getNodeValue());
            }
        } while ((node = node.getNextSibling()) != null);
        return valueBuffer.toString();
    }

    public static String checkEmpty(String string) {
        if (string != null && string.length() > 0)
            return string;
        else
            return "";
    }

    public static String checkEmpty(String string1, String string2) {
        if (string1 != null && string1.length() > 0)
            return string1;
        else if (string2 != null && string2.length() > 0)
            return string2;
        else
            return "";
    }

    public static String checkEmpty(String string1, String string2, String string3) {
        if (string1 != null && string1.length() > 0)
            return string1;
        else if (string2 != null && string2.length() > 0)
            return string2;
        else if (string3 != null && string3.length() > 0)
            return string3;
        else
            return "";
    }

    public static boolean checkBoolean(String str) {
        return checkBoolean(str, false);
    }

    public static boolean checkBoolean(String str, boolean defaultValue) {
        if (defaultValue) {
            //default to true, ie anything but false is true
            return !"false".equals(str);
        } else {
            //default to false, ie anything but true is false
            return "true".equals(str);
        }
    }
    
    public static Document removeSingleNode(Document document, String nodeName) {
    	if(document == null) {
    		return document;
    	}
    	
    	NodeList nodes = document.getElementsByTagName(nodeName);
    	if (nodes != null && nodes.getLength() > 0) {
    		Node item = nodes.item(0);
    		item.getParentNode().removeChild(item);
		}
		return document;
    }
    
    public static String readElementAttribute(Element element,String attrName) {
	if(element == null || !StringUtils.hasText(attrName)) {
	    return null;
	}
	
	return element.getAttribute(attrName);
    }
    
    public static Long readLongElementAttribute(Element element,String attrName) {
	if(element == null || !StringUtils.hasText(attrName)) {
	    return null;
	}
	
	String attribute = element.getAttribute(attrName);
	return Long.valueOf(attribute);
    }
    
    public static Boolean readBooleanElementAttribute(Element element,String attrName) {
	if(element == null || !StringUtils.hasText(attrName)) {
	    return null;
	}
	
	String attribute = element.getAttribute(attrName);
	return Boolean.valueOf(attribute);
    }
    
    public static Integer readIntegerElementAttribute(Element element,String attrName) {
	if(element == null || !StringUtils.hasText(attrName)) {
	    return null;
	}
	
	String attribute = element.getAttribute(attrName);
	if(StringUtils.hasText(attribute)) {
	    return Integer.valueOf(attribute);
	}
	
	return null;
    }
    
    
}
