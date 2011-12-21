/**
 * 
 */
package com.openappengine.facade.ui.widgets.container;


/**
 * @author hrishikesh.joshi
 * @Dec 21, 2011
 */
public class ContainerPanel extends Container {

	private static final long serialVersionUID = 1L;
	
	private Container headerPanel;
	
	private Container leftPanel;
	
	private Container centerPanel;
	
	private Container rightPanel;
	
	private Container footerPanel;

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
