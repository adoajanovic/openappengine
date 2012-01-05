package com.openappengine.navigation;

import java.io.Serializable;
import javax.faces.event.ActionEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.CustomScoped;
/**
 * <p>The NavigationBean class is responsible for storing the state of the
 * included dynamic content for display.  </p>
 */
@ManagedBean (name="navigation")
@CustomScoped(value = "#{window}")
public class NavigationBean implements Serializable{

    // selected include contents.
    @ManagedProperty(value = "#{selectedIncludePath}")
    private String selectedIncludePath="content/splash.xhtml";

    public NavigationBean(){
 //       System.out.println("NavigationBean version="+this);
    }

    /**
     * Gets the currently selected content include path.
     *
     * @return currently selected content include path.
     */
    public String getSelectedIncludePath() {
        if (null == selectedIncludePath)this.selectedIncludePath="content/splash.xhtml";
 //       System.out.println("selectedIncludePath="+this.selectedIncludePath);
        return selectedIncludePath;
    }

    /**
     * Sets the selected content include path to the specified path.
     *
     * @param selectedIncludePath the specified content include path.
     */
    public void setSelectedIncludePath(String selectedIncludePath) {
        this.selectedIncludePath = selectedIncludePath;
    }

    /**
     * ActionHandler Listener for the changes the selected content path.
     *
     * @param event JSF ActionHandler TransitionEvent.
     */
    public void contentHomePathChange(ActionEvent event){

        // Retrieve content include path from the context.
       this.setSelectedIncludePath("content/splash.xhtml");
    }

    public void content1PathChange(ActionEvent e){
        this.setSelectedIncludePath("content/content1.xhtml");
    }
   public void content2PathChange(ActionEvent e){
        this.setSelectedIncludePath("content/content2.xhtml");
  //      System.out.println("content1PathChange :-"+this.selectedIncludePath);
    }
}
