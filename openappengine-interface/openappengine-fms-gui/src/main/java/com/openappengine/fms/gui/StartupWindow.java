package com.openappengine.fms.gui;
 
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.HashMap;
import org.apache.pivot.collections.Map;
import org.apache.pivot.serialization.SerializationException;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Border;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.Frame;
import org.apache.pivot.wtk.MenuHandler;
import org.apache.pivot.wtk.TabPane;

import com.openappengine.fms.util.PivotUtils;
 
public class StartupWindow extends Frame implements Bindable {
	
    @BXML 
    private TabPane tabPane = null;
    
    private java.util.Map<String, Object> tabs = new java.util.HashMap<String, Object>();
 
    private MenuHandler menuHandler = new MenuHandler.Adapter();
 
    public StartupWindow() {
        addAction_VehicleTypeNew();
        
        addAction_VehicleNew();
        
        addAction_VehicleListing();
        
        addAction_ProductNew();
        
        addAction_CustomerNew();
        
        addAction_CustomerList();
    }

	private void addAction_VehicleTypeNew() {
		Action.getNamedActions().put("vehicleTypeNew", new Action() {
            @Override
            public void perform(Component source) {
                BXMLSerializer bxmlSerializer = new BXMLSerializer();
                bxmlSerializer.getNamespace().put("menuHandler", menuHandler);
 
                Component tab;
                try {
                	InputStream is = getClass().getClassLoader().getResourceAsStream("VehicleType.bxml");
                    tab = new Border((Component)bxmlSerializer.readObject(is));
                } catch (IOException exception) {
                    throw new RuntimeException(exception);
                } catch (SerializationException exception) {
                    throw new RuntimeException(exception);
                }
                String tabTitle = "New Vehicle Type";
                getTabPane().getTabs().add(tab);
                tabs.put(tabTitle, tab);
				TabPane.setTabData(tab, tabTitle);
                getTabPane().setSelectedIndex(getTabPane().getTabs().getLength() - 1);
            }
        });
	}
	
	private void addAction_VehicleNew() {
		Action.getNamedActions().put("vehicleNew", new Action() {
            @Override
            public void perform(Component source) {
                BXMLSerializer bxmlSerializer = new BXMLSerializer();
                bxmlSerializer.getNamespace().put("menuHandler", menuHandler);
 
                PivotUtils.addTab(StartupWindow.this, "Vehicle.bxml", new HashMap<String, Object>(), "New Vehicle");
            }
        });
	}
	
	private void addAction_VehicleListing() {
		Action.getNamedActions().put("vehicleListing", new Action() {
            @Override
            public void perform(Component source) {
                BXMLSerializer bxmlSerializer = new BXMLSerializer();
                bxmlSerializer.getNamespace().put("menuHandler", menuHandler);
 
                PivotUtils.addTab(StartupWindow.this, "VehicleListing.bxml", new HashMap<String, Object>(), "Vehicle Listing");
            }
        });
	}
	
	private void addAction_ProductNew() {
		Action.getNamedActions().put("productNew", new Action() {
            @Override
            public void perform(Component source) {
                BXMLSerializer bxmlSerializer = new BXMLSerializer();
                bxmlSerializer.getNamespace().put("menuHandler", menuHandler);
 
                PivotUtils.addTab(StartupWindow.this, "Product.bxml", new HashMap<String, Object>(), "New Product");
            }
        });
	}
	
	private void addAction_CustomerNew() {
		Action.getNamedActions().put("customerNew", new Action() {
            @Override
            public void perform(Component source) {
                BXMLSerializer bxmlSerializer = new BXMLSerializer();
                bxmlSerializer.getNamespace().put("menuHandler", menuHandler);
 
                PivotUtils.addTab(StartupWindow.this, "Customer.bxml", new HashMap<String, Object>(), "New Customer");
            }
        });
	}
	
	private void addAction_CustomerList() {
		Action.getNamedActions().put("customerList", new Action() {
            @Override
            public void perform(Component source) {
                BXMLSerializer bxmlSerializer = new BXMLSerializer();
                bxmlSerializer.getNamespace().put("menuHandler", menuHandler);
 
                PivotUtils.addTab(StartupWindow.this, "CustomerListing.bxml", new HashMap<String, Object>(), "Customer Listing");
            }
        });
	}
	
 
    @Override
    public void initialize(Map<String, Object> namespace, URL location, Resources resources) {
    }

	public TabPane getTabPane() {
		return tabPane;
	}

	public void setTabPane(TabPane tabPane) {
		this.tabPane = tabPane;
	}
}