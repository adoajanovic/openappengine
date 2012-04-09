package com.openappengine.fms.gui;

import java.io.InputStream;

import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.concurrent.Task;
import org.apache.pivot.util.concurrent.TaskExecutionException;
import org.apache.pivot.util.concurrent.TaskListener;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.DesktopApplicationContext;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.Window;

import com.openappengine.service.ServiceEngineContextStartup;

public class Main implements Application {
	
	private Window window = null;

	@Override
	public void startup(Display display, Map<String, String> properties)
			throws Exception {
		
		final BXMLSerializer bxmlSerializer = new BXMLSerializer();
		InputStream is = getClass().getClassLoader().getResourceAsStream("Startup.bxml");
        window = (Window)bxmlSerializer.readObject(is);
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
		DesktopApplicationContext.main(Main.class, args);
	}
}
