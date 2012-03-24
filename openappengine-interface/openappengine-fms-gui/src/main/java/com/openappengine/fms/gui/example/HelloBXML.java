package com.openappengine.fms.gui.example;

import java.io.InputStream;

import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.DesktopApplicationContext;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.TextInput;
import org.apache.pivot.wtk.Window;

import com.openappengine.service.ServiceEngineContextStartup;

public class HelloBXML implements Application {
	private Window window = null;
	private Label label;
	private PushButton button1;
	private TextInput text1;

	@Override
	public void startup(Display display, Map<String, String> properties)
			throws Exception {
		
		new ServiceEngineContextStartup().startup();
		
		final BXMLSerializer bxmlSerializer = new BXMLSerializer();
		InputStream is = getClass().getClassLoader().getResourceAsStream("menuBars.bxml");
        window = (Window)bxmlSerializer.readObject(is);
        
        /*button1 = (PushButton) bxmlSerializer.getNamespace().get("button1");
        button1.getButtonPressListeners().add(new ButtonPressListener() {
			@Override
			public void buttonPressed(Button btn) {
				text1 = (TextInput) bxmlSerializer.getNamespace().get("lastNameTextInput");
				System.out.println(text1.getText());
			}
		});*/
        window.open(display);
	}

	@Override
	public boolean shutdown(boolean optional) {
		if (window != null) {
			window.close();
		}

		return false;
	}

	@Override
	public void suspend() {
	}

	@Override
	public void resume() {
	}

	public static void main(String[] args) {
		DesktopApplicationContext.main(HelloBXML.class, args);
	}
}
