package com.openappengine.gui.engine.core.widget.control.custom;

import java.util.List;

import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.widget.control.Control;
import com.openappengine.gui.engine.core.widget.control.WidgetControlWriter;

@Control(widgetControlName="dropdown")
public class DropDownControl extends AbstractBaseWidgetControl {

	@Override
	public void encodeBegin(Element element, GuiEngineContext context,
			WidgetControlWriter writer) {
		writer.startElement("dropdown");
		writeIdAttribute(element, writer);
		writeLabelIdAttribute(element, writer);
		writeNameAttribute(element, writer);
		writeRequiredAttribute(element, writer);
		writer.writeValue(element.getNodeValue());
	}

	@Override
	public void encodeEnd(Element element, GuiEngineContext context,
			WidgetControlWriter writer) {
		writer.endElement("dropdown");
	}

	@Override
	public boolean rendersChildren() {
		return false;
	}

	@Override
	public void encodeChildren(Element element, GuiEngineContext context,WidgetControlWriter writer) {
		List<Element> elements = DomUtils.getChildElements(element);
		for (Element optionEle : elements) {
			if(optionEle.getNodeName().equals("option")) {
				writer.startElement("option");
				writeLabelIdAttribute(optionEle, writer);
				writer.writeAttribute("value", optionEle.getAttribute("value"));
				writer.endElement("option");
			}
		}
	}
	
}
