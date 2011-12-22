/**
 * 
 */
package com.openappengine.facade.ui.widgets.container;

import java.io.Serializable;


/**
 * @author hrishikesh.joshi
 * @Dec 21, 2011
 */
public class ContainerPanel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Container headerPanel = new Container();
	
	private Container leftPanel= new Container();
	
	private Container centerPanel;
	
	private Container rightPanel = new Container();
	
	private Container footerPanel = new Container();
	
	public ContainerPanel() {
	}

	public Container getHeaderPanel() {
		return headerPanel;
	}

	public void setHeaderPanel(Container headerPanel) {
		this.headerPanel = headerPanel;
	}

	public Container getLeftPanel() {
		return leftPanel;
	}

	public void setLeftPanel(Container leftPanel) {
		this.leftPanel = leftPanel;
	}

	public Container getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(Container centerPanel) {
		this.centerPanel = centerPanel;
	}

	public Container getRightPanel() {
		return rightPanel;
	}

	public void setRightPanel(Container rightPanel) {
		this.rightPanel = rightPanel;
	}

	public Container getFooterPanel() {
		return footerPanel;
	}

	public void setFooterPanel(Container footerPanel) {
		this.footerPanel = footerPanel;
	}
	
}
