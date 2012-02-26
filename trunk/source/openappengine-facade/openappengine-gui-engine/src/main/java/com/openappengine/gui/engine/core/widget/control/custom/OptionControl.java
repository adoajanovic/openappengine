package com.openappengine.gui.engine.core.widget.control.custom;

import org.w3c.dom.Element;

import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.widget.control.Control;
import com.openappengine.gui.engine.core.widget.control.WidgetControlWriter;

@Control(widgetControlName="option")
public class OptionControl extends AbstractBaseWidgetControl {

	@Override
	public void encodeBegin(Element element, GuiEngineContext context,
			WidgetControlWriter writer) {
		writer.startElement("option");
		writeIdAttribute(element, writer);
		writeLabelIdAttribute(element, writer);
		writer.writeAttribute("value", element.getAttribute("value"));
	}

	@Override
	public void encodeEnd(Element element, GuiEngineContext context,
			WidgetControlWriter writer) {
		writer.endElement("option");
	}

	@Override
	public boolean rendersChildren() {
		return true;
	}

}
