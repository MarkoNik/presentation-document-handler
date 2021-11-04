package view.gui.tree.view;

import model.nodes.RuNode;
import view.gui.tree.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class MyTree extends JTree {
    DefaultTreeModel treeModel;

    public MyTree(MyTreeNode root) {
        setModel(new DefaultTreeModel(root));
    }
}
