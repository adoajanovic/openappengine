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
import org.apache.pivot.wtk.FileBrowserSheet;
import org.apache.pivot.wtk.Frame;
import org.apache.pivot.wtk.MenuBar;
import org.apache.pivot.wtk.MenuHandler;
import org.apache.pivot.wtk.TabPane;
import org.apache.pivot.wtk.TextInput;
import org.apache.pivot.wtk.TextInputContentListener;
import org.apache.pivot.wtk.TextInputSelectionListener;

import com.openappengine.fms.util.PivotUtils;
 
public class DefaultWindow extends Frame implements Bindable {
    @BXML private FileBrowserSheet fileBrowserSheet;
    
    @BXML private TabPane tabPane = null;
    
    private java.util.Map<String, Object> tabs = new java.util.HashMap<String, Object>();
 
    private MenuHandler menuHandler = new MenuHandler.Adapter() {
        TextInputContentListener textInputTextListener = new TextInputContentListener.Adapter() {
            @Override
            public void textChanged(TextInput textInput) {
                updateActionState(textInput);
            }
        };
 
        TextInputSelectionListener textInputSelectionListener = new TextInputSelectionListener() {
            @Override
            public void selectionChanged(TextInput textInput, int previousSelectionStart,
                int previousSelectionLength) {
                updateActionState(textInput);
            }
        };
 
        @Override
        public void configureMenuBar(Component component, MenuBar menuBar) {
            if (component instanceof TextInput) {
                TextInput textInput = (TextInput)component;
 
                updateActionState(textInput);
                Action.getNamedActions().get("paste").setEnabled(true);
 
                textInput.getTextInputContentListeners().add(textInputTextListener);
                textInput.getTextInputSelectionListeners().add(textInputSelectionListener);
            } else {
                Action.getNamedActions().get("cut").setEnabled(false);
                Action.getNamedActions().get("copy").setEnabled(false);
                Action.getNamedActions().get("paste").setEnabled(false);
            }
        }
 
        @Override
        public void cleanupMenuBar(Component component, MenuBar menuBar) {
            if (component instanceof TextInput) {
                TextInput textInput = (TextInput)component;
                textInput.getTextInputContentListeners().remove(textInputTextListener);
                textInput.getTextInputSelectionListeners().remove(textInputSelectionListener);
            }
        }
 
        private void updateActionState(TextInput textInput) {
            Action.getNamedActions().get("cut").setEnabled(textInput.getSelectionLength() > 0);
            Action.getNamedActions().get("copy").setEnabled(textInput.getSelectionLength() > 0);
        }
    };
 
    public DefaultWindow() {
        addAction_VehicleTypeNew();
        
        addAction_VehicleNew();
        
        Action.getNamedActions().put("fileNew", new Action() {
            @Override
            public void perform(Component source) {
                BXMLSerializer bxmlSerializer = new BXMLSerializer();
                bxmlSerializer.getNamespace().put("menuHandler", menuHandler);
 
                Component tab;
                try {
                	InputStream is = getClass().getClassLoader().getResourceAsStream("hello.bxml");
                    tab = new Border((Component)bxmlSerializer.readObject(is));
                } catch (IOException exception) {
                    throw new RuntimeException(exception);
                } catch (SerializationException exception) {
                    throw new RuntimeException(exception);
                }
 
                getTabPane().getTabs().add(tab);
                TabPane.setTabData(tab, "Document " + getTabPane().getTabs().getLength());
                getTabPane().setSelectedIndex(getTabPane().getTabs().getLength() - 1);
            }
        });
 
        Action.getNamedActions().put("fileOpen", new Action() {
            @Override
            public void perform(Component source) {
                fileBrowserSheet.open(DefaultWindow.this);
            }
        });
 
        Action.getNamedActions().put("cut", new Action(false) {
            @Override
            public void perform(Component source) {
                TextInput textInput = (TextInput)DefaultWindow.this.getFocusDescendant();
                textInput.cut();
            }
        });
 
        Action.getNamedActions().put("copy", new Action(false) {
            @Override
            public void perform(Component source) {
                TextInput textInput = (TextInput)DefaultWindow.this.getFocusDescendant();
                textInput.copy();
            }
        });
 
        Action.getNamedActions().put("paste", new Action(false) {
            @Override
            public void perform(Component source) {
                TextInput textInput = (TextInput)DefaultWindow.this.getFocusDescendant();
                textInput.paste();
            }
        });
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
 
                PivotUtils.addTab(DefaultWindow.this, "Vehicle.bxml", new HashMap<String, Object>(), "New Vehicle");
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