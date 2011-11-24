/*
 * Version: MPL 1.1
 *
 * "The contents of this file are subject to the Mozilla Public License
 * Version 1.1 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations under
 * the License.
 *
 * The Original Code is ICEfaces 1.5 open source software code, released
 * November 5, 2006. The Initial Developer of the Original Code is ICEsoft
 * Technologies Canada, Corp. Portions created by ICEsoft are Copyright (C)
 * 2004-2010 ICEsoft Technologies Canada, Corp. All Rights Reserved.
 *
 * Contributor(s): _____________________.
 *
 */
package com.openappengine.content;

import com.icesoft.faces.component.dragdrop.DropEvent;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.tree.IceUserObject;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.io.Serializable;
import java.util.Map;
import javax.faces.context.FacesContext;

/**
 * <p>The TreeBean class is the backing bean for the Tree Component showcase
 * demonstration. It is used to store and display the selected tree node</p>
 *
 * @see NodeUserObject
 * @since 0.3.0
 */
@ManagedBean(name = "treeController")
@ViewScoped
public class TreeController implements Serializable {

    // tree default model, used as a value for the tree component
    private DefaultTreeModel model;
    private EmployeeUserObject selectedUserObject;

    /**
     * Construct the default tree structure by combining tree nodes.
     */
    public TreeController() {
        init();
    }

    public DefaultTreeModel getModel() {
        return model;
    }

    public void setModel(DefaultTreeModel model) {
        this.model = model;
    }

    public NodeUserObject getSelectedUserObject() {
        return selectedUserObject;
    }

    public void employeeNodeSelected(ActionEvent event) {
        // get employee id
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String employeeId =(String) map.get("employeeId");

        // find employee node by id and make it the selected node
        DefaultMutableTreeNode node = findTreeNode(employeeId);
        selectedUserObject = (EmployeeUserObject) node.getUserObject();
        // fire effects.);
 
    }

    public ArrayList getSelectedTreePath() {
        Object[] objectPath = selectedUserObject.getWrapper().getUserObjectPath();
        ArrayList treePath = new ArrayList();
        Object anObjectPath;
        for(int i= 0, max = objectPath.length; i < max; i++){
            anObjectPath = objectPath[i];
            IceUserObject userObject = (IceUserObject) anObjectPath;
            treePath.add(userObject.getText());
        }
        return treePath;
    }

    public boolean isMoveUpDisabled() {
        DefaultMutableTreeNode selectedNode = selectedUserObject.getWrapper();
        return isMoveDisabled(selectedNode, selectedNode.getPreviousNode());
    }

    public boolean isMoveDownDisabled() {
        DefaultMutableTreeNode selectedNode = selectedUserObject.getWrapper();
        return isMoveDisabled(selectedNode, selectedNode.getNextNode());
    }

    public boolean isMoveDisabled(DefaultMutableTreeNode selected, DefaultMutableTreeNode swapper) {
        return selected == null || swapper == null || selected.getAllowsChildren() || swapper.isRoot();
    }

    public void moveUp(ActionEvent event) {
        DefaultMutableTreeNode selectedNode = selectedUserObject.getWrapper();
        exchangeNodes(selectedNode.getPreviousNode(), selectedNode);
    }

    public void moveDown(ActionEvent event) {
        DefaultMutableTreeNode selectedNode = selectedUserObject.getWrapper();
        exchangeNodes(selectedNode, selectedNode.getNextNode());
    }

    public void exchangeNodes(DefaultMutableTreeNode node1, DefaultMutableTreeNode node2) {
        DefaultMutableTreeNode node1Parent = (DefaultMutableTreeNode) node1.getParent();
        DefaultMutableTreeNode node2Parent = (DefaultMutableTreeNode) node2.getParent();
        DefaultMutableTreeNode node1PrevNode = node1.getPreviousNode();
        DefaultMutableTreeNode node1PrevNodeParent = (DefaultMutableTreeNode) node1PrevNode.getParent();
        int childCount = 0;
        
        if (node1.isNodeDescendant(node2)) {
            while (node2.getChildCount() > 0) {
                node1.insert((MutableTreeNode) node2.getFirstChild(), childCount++);
            }
            if (node1PrevNode == node1Parent ||
                    (node1PrevNode.isNodeSibling(node1) && !node1PrevNode.getAllowsChildren())) {
                node1Parent.insert(node2, node1Parent.getIndex(node1));
            } else if (node1PrevNode.getAllowsChildren()) {
                node1PrevNode.add(node2);
            } else {
                node1PrevNodeParent.add(node2);
            }

            return;
        }

        if (node2.getAllowsChildren()) {
            node2.insert(node1, 0);
        } else {
            node1.removeFromParent();
            node2Parent.insert(node1, node2Parent.getIndex(node2) + 1);
        }
    }

    public void dropListener(DropEvent event) {
        HtmlPanelGroup panelGroup = (HtmlPanelGroup) event.getComponent();

        DefaultMutableTreeNode dragNode = (DefaultMutableTreeNode) event.getTargetDragValue();
        DefaultMutableTreeNode dropNode = (DefaultMutableTreeNode) panelGroup.getDropValue();
        DefaultMutableTreeNode dropNodeParent = (DefaultMutableTreeNode) dropNode.getParent();

        if (dragNode.isNodeDescendant(dropNode)) return;

        if (dropNode.getAllowsChildren()) {
            dropNode.insert(dragNode, 0);
        } else {
            dragNode.removeFromParent();
            dropNodeParent.insert(dragNode, dropNodeParent.getIndex(dropNode) + 1);
        }
    }

    private DefaultMutableTreeNode addNode(DefaultMutableTreeNode parent,
                                           String title,
                                           Employee employee) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        EmployeeUserObject userObject = new EmployeeUserObject(node);
        node.setUserObject(userObject);
        userObject.setEmployee(employee);

        // non-employee node or branch
        if (title != null) {
            userObject.setText(title);
            userObject.setLeaf(false);
            userObject.setExpanded(true);
            node.setAllowsChildren(true);
        }
        // employee node
        else {
            userObject.setText(employee.getLastName() + ", " +
                    employee.getFirstName());
            userObject.setLeaf(true);
            node.setAllowsChildren(false);
        }
        // finally add the node to the parent. 
        if (parent != null) {
            parent.add(node);
        }

        return node;
    }

    protected void init() {
        DefaultMutableTreeNode rootNode = addNode(null, "Employees",
                new Employee(new Long(0), "", "", "", "", ""));
        model = new DefaultTreeModel(rootNode);
        selectedUserObject = (EmployeeUserObject) rootNode.getUserObject();
        selectedUserObject.setExpanded(true);
        DefaultMutableTreeNode regionNode = addNode(rootNode, "Western",
                new Employee(new Long(1), "", "", "", "", ""));
        addNode(regionNode, null,
                new Employee(new Long(10), "Western", "Calgary", "Ethan", "Smith", "555-4562"));
        addNode(regionNode, null,
                new Employee(new Long(15), "Western", "Calgary", "Jacob", "Smith", "555-4563"));
        addNode(regionNode, null,
                new Employee(new Long(50), "Western", "Victoria", "Daniel", "Williams", "555-4572"));
        addNode(regionNode, null,
                new Employee(new Long(120), "Western", "Victoria", "Andrew", "Brown", "555-4577"));

        regionNode = addNode(rootNode, "Central", new Employee(new Long(2), "", "", "", "", ""));
        addNode(regionNode, null,
                new Employee(new Long(140), "Central", "Kitchener", "Joshua", "Brown", "555-4579"));
        addNode(regionNode, null,
                new Employee(new Long(150), "Central", "Kitchener", "Christopher", "Brown", "555-4580"));
        addNode(regionNode, null,
                new Employee(new Long(260), "Central", "Toronto", "Vincent", "Miller", "555-4591"));
        addNode(regionNode, null,
                new Employee(new Long(300), "Central", "Waterloo", "Matthew", "Davis", "555-4595"));

        regionNode = addNode(rootNode, "Eastern", new Employee(new Long(3), "", "", "", "", ""));
        addNode(regionNode, null,
                new Employee(new Long(340), "Eastern", "Ottawa", "Alexander", "Garcia", "555-4590"));
        addNode(regionNode, null,
                new Employee(new Long(360), "Eastern", "Ottawa", "Jacob", "Garcia", "555-4592"));
        addNode(regionNode, null,
                new Employee(new Long(350), "Eastern", "Ottawa", "Benjamin", "Garcia", "555-4591"));
        addNode(regionNode, null,
                new Employee(new Long(420), "Eastern", "Halifax", "Joshua", "Rodriguez", "555-4598"));

    }

    private DefaultMutableTreeNode findTreeNode(String nodeId) {
        DefaultMutableTreeNode rootNode =
                (DefaultMutableTreeNode) model.getRoot();
        DefaultMutableTreeNode node;
        EmployeeUserObject tmp;
        Enumeration nodes = rootNode.depthFirstEnumeration();
        while (nodes.hasMoreElements()) {
            node = (DefaultMutableTreeNode) nodes.nextElement();
            tmp = (EmployeeUserObject) node.getUserObject();
            if (nodeId.equals(String.valueOf(tmp.getEmployee().getId()))) {
                return node;
            }
        }
        return null;
    }
}
