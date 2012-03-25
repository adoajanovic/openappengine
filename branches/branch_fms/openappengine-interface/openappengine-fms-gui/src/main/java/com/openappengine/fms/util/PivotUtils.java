/**
 * 
 */
package com.openappengine.fms.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.collections.HashMap;
import org.apache.pivot.serialization.SerializationException;
import org.apache.pivot.wtk.Border;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.TabPane;
import org.apache.pivot.wtk.Window;

import com.openappengine.fms.gui.example.MenuBars;

/**
 * @author hrishi
 *
 */
public class PivotUtils {
	
	public static Window getWindow(Component component) {
		if(component == null) {
			return null;
		}
		
		return component.getWindow();
	}
	
	public static void addTab(Component c, String bxmlFile,HashMap<String, Object> namespace,String title) {
		MenuBars window = (MenuBars) getWindow(c);
		TabPane tabPane = window.getTabPane();
		Component component = PivotUtils.getResourceAsBorderComponent(bxmlFile,namespace);
		tabPane.getTabs().add(component);
		TabPane.setTabData(component, title);
        tabPane.setSelectedIndex(tabPane.getTabs().getLength() - 1);
	}
	
	public static Object readObject(String classpathResource,HashMap<String, Object> namespace) {
		InputStream is = PivotUtils.class.getClassLoader().getResourceAsStream(classpathResource);
		if(is == null) {
			throw new NullPointerException("Cannot read resource " + classpathResource);
		}
		
		BXMLSerializer bxmlSerializer = new BXMLSerializer();
		bxmlSerializer.setNamespace(namespace);
		try {
			return bxmlSerializer.readObject(is);
		} catch (IOException e) {
			throw new IllegalArgumentException("Cannot read resource " + classpathResource,e);
		} catch (SerializationException e) {
			throw new IllegalArgumentException("Cannot read resource " + classpathResource,e);
		}
	}
	
	public static Component getResourceAsBorderComponent(String location,HashMap<String, Object> namespace) {
		Object object = readObject(location,namespace);
		return new Border((Component) object);
	}

}
