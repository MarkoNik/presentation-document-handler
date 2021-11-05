package view.gui.tree.controller;

import view.gui.tree.model.MyTreeNode;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class RuTreeSelectionListener implements TreeSelectionListener {
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        MyTreeNode treeItemSelected = (MyTreeNode)path.getLastPathComponent();
        System.out.println("Selektovan cvor:"+ treeItemSelected.getName());
        System.out.println("getPath: "+e.getPath());
    }
}
