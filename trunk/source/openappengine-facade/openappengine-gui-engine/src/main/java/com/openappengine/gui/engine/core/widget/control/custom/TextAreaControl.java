package com.openappengine.gui.engine.core.widget.control.custom;

import org.w3c.dom.Element;

import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.widget.control.Control;
import com.openappengine.gui.engine.core.widget.control.WidgetControlWriter;

@Control(widgetControlName="textarea")
public class TextAreaControl extends AbstractBaseWidgetControl {

	@Override
	public void encodeBegin(Element element, GuiEngineContext context,
			WidgetControlWriter writer) {
		writer.startElement("textarea");
		writeIdAttribute(element, writer);
		writeLabelIdAttribute(element, writer);
		writeNameAttribute(element, writer);
		writeRequiredAttribute(element, writer);
		writer.writeAttribute("rows", element.getAttribute("rows"));
		writer.writeAttribute("cols", element.getAttribute("cols"));
		writer.writeValue(element.getNodeValue());
	}

	@Override
	public void encodeEnd(Element element, GuiEngineContext context,
			WidgetControlWriter writer) {
		writer.endElement("textarea");
	}

	@Override
	public boolean rendersChildren() {
		return true;
	}

}
