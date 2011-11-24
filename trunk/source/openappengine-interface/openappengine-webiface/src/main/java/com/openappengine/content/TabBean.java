package com.openappengine.content;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;


import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import com.icesoft.faces.component.dragdrop.DndEvent;
import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import javax.faces.application.FacesMessage;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;

import org.icefaces.component.tab.TabSet;

@ManagedBean (name="tabBean")
@SessionScoped
public class TabBean implements Serializable{
    private String inpTxt;
    private String richText;
    private TabSet tabSet;
    private int tabIndex = 0;

    private String tabContents = "This tabPane represents a simple pane with text";
 

    private boolean renderPanel = true; 
    private List<Employee> employees = new ArrayList<Employee>();
    private List<Employee> selectedEmployees = new ArrayList<Employee>();
    
    public TabBean() {
    	employees.add(new Employee(new Long(12300123), "John", "Smith", "123 Oak Dr, Calgary, AB", "jsmith@icesoft.com"));
    	employees.add(new Employee(new Long(12300951), "Nancy", "Brown", "456 Elm Lane, Calgary, AB", "nbrown@icesoft.com"));
    	employees.add(new Employee(new Long(12400002), "James", "Gagnon", "789 Birch Grove, Calgary, AB", "jgagnon@icesoft.com"));
    	employees.add(new Employee(new Long(12299944), "Sara", "Messier", "120 Maple Circle, Calgary, AB", "smessier@icesoft.com"));
    }
    
   public void tabsetChangeListener(ValueChangeEvent event) {
        System.out.println("tabsetChangeListener "+ event.getComponent());
   }
   
    public String getInpTxt() {
        return inpTxt;
    }
    public void setInpTxt(String inpTxt) {
        this.inpTxt = inpTxt;
    }
    public String getRichText() {
        return richText;
    }
    public void setRichText(String richText) {
        this.richText = richText;
    }

    public TabSet getTabSet() {
        return tabSet;
    }
    public void setTabSet(TabSet tabSet) {
        this.tabSet = tabSet;
    } 
    int i=2;
 
    public int getTabIndex() {
        return tabIndex;
    }
    public void setTabIndex(int tabIndex) {
        this.tabIndex = tabIndex;
   }


    public void tabIndexChanged(ValueChangeEvent event) {
        System.out.println("------>> TabIndexChanged");
        
        try {
            tabIndex = ((Integer)event.getNewValue()).intValue();
        } catch (Exception e){}
    }
    
 
    public void removeEmployee(ActionEvent event){
        //remove them from the list!
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        int employeeId = Integer.parseInt((String) map.get("employeeId"));
        System.out.println(" employeeId to delete="+employeeId);
        for (int i=0; i<this.selectedEmployees.size(); i++){
           Employee e = (Employee)selectedEmployees.get(i);
           if (e.getId() == employeeId){
                boolean remove = this.selectedEmployees.remove(e);
            }
        }

    }

    public void addEmployee(DragEvent event){
        //only add them to the list if they aren't already there!
        if (event.getEventType() == DndEvent.DROPPED) {
            String targetId = event.getTargetClientId();
            if ((targetId != null)) {
                // the Employee being dragged
                Employee emp =
                        (Employee) ((HtmlPanelGroup) event.getComponent()).getDragValue();

                // make sure we have inventory to sell
                if (!selectedEmployees.contains(emp)) {
                    // only add if not already there
                    selectedEmployees.add(emp);
                }
            }
        }
    }

 
    public void toggleRenderPanel(ActionEvent event) {
    	renderPanel = !renderPanel;    	
    }


	public boolean isRenderPanel() {
			return renderPanel;
	}

	public void setRenderPanel(boolean renderPanel) {
			this.renderPanel = renderPanel;
	}

   public List<Employee> getEmployees() {
		return employees;
   }
    public void setEmployees(List<Employee> employees) {
		this.employees = employees;
    }

    public List<Employee> getSelectedEmployees() {
        return selectedEmployees;
    }

    public void setSelectedEmployees(List<Employee> selectedEmployees) {
        this.selectedEmployees = selectedEmployees;
    }
	
}
