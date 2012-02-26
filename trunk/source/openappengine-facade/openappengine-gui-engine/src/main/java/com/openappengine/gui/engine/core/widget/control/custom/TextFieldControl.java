package com.openappengine.gui.engine.core.widget.control.custom;

import org.w3c.dom.Element;

import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.widget.control.Control;
import com.openappengine.gui.engine.core.widget.control.WidgetControlWriter;

@Control(widgetControlName="textfield")
public class TextFieldControl extends AbstractBaseWidgetControl {

	@Override
	public void encodeBegin(Element element, GuiEngineContext context,
			WidgetControlWriter writer) {
		writer.startElement("textfield");
		writeIdAttribute(element, writer);
		writeLabelIdAttribute(element, writer);
		writeNameAttribute(element, writer);
		writeRequiredAttribute(element, writer);
		writer.writeValue(element.getNodeValue());
	}

	@Override
	public void encodeEnd(Element element, GuiEngineContext context,
			WidgetControlWriter writer) {
		writer.endElement("textfield");
	}

	@Override
	public boolean rendersChildren() {
		return true;
	}

}
