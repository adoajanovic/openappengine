/**
 * 
 */
package com.openappengine.autocomplete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.openappengine.web.utils.TagUtils;

/**
 * @author hrishikesh.joshi
 *
 */
public class AutocompleteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List adList = new ArrayList();
	
	public AutocompleteBean() {
	}
	
	public List getADList(String listType) {
		if(adList == null || adList.isEmpty()) {
			adList = TagUtils.getADDataList(listType);
		}
		return adList;
	}
	
	public void handleTextChange(ValueChangeEvent event) {
		SelectInputText selectInputText = (SelectInputText) event.getComponent();
		int maxMatches = selectInputText.getRows();
		List matchList = new ArrayList(maxMatches);
		String search = (String) event.getNewValue();
		//List listValue = selectInputText.getListValue();
		
		Iterator itemListIterator = selectInputText.getItemList();
		if(itemListIterator != null) {
			while(itemListIterator.hasNext()) {
				Object listItem = itemListIterator.next();
				if(listItem instanceof SelectItem) {
					SelectItem selectItem = (SelectItem) listItem;
					if(selectItem.getLabel().startsWith(search)) {
						matchList.add(selectItem);
					}
				}
			}
		}
		
		setAdList(matchList);
	}

	public List getAdList() {
		return adList;
	}

	public void setAdList(List adList) {
		this.adList = adList;
	}

}
