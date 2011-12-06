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

import org.springframework.util.StringUtils;

import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.openappengine.web.utils.TagUtils;

/**
 * @author hrishikesh.joshi
 *
 */
public class AutocompleteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List adList = new ArrayList();
	
	private List adMatches = new ArrayList();
	
	private boolean filteredList;
	
	public AutocompleteBean() {
	}
	
	public List getADList(String listType) {
		if(!filteredList) {
			adList = TagUtils.getADDataList(listType);
			adMatches = adList;
			setFilteredList(false);
		}
		return adMatches;
	}
	
	public void handleTextChange(ValueChangeEvent event) {
		SelectInputText selectInputText = (SelectInputText) event.getComponent();
		int maxMatches = selectInputText.getRows();
		List matchList = new ArrayList(maxMatches);
		
		String search = (String) event.getNewValue();
		if(StringUtils.hasText(search)) {
			setFilteredList(true);
			Iterator adListIterator = adList.iterator();
			if(adListIterator != null) {
				while(adListIterator.hasNext()) {
					Object listItem = adListIterator.next();
					if(listItem instanceof SelectItem) {
						SelectItem selectItem = (SelectItem) listItem;
						if(selectItem.getLabel().startsWith(search)) {
							matchList.add(selectItem);
						}
					}
				}
			}
			adMatches = matchList;
		} else {
			setFilteredList(false);
			adMatches = adList;
		}
	}

	public List getAdList() {
		return adList;
	}

	public void setAdList(List adList) {
		this.adList = adList;
	}

	public boolean isFilteredList() {
		return filteredList;
	}

	public void setFilteredList(boolean filteredList) {
		this.filteredList = filteredList;
	}

	public List getAdMatches() {
		return adMatches;
	}

	public void setAdMatches(List adMatches) {
		this.adMatches = adMatches;
	}

}
