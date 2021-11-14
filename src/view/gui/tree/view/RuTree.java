package view.gui.tree.view;

import view.gui.tree.controller.RuTreeCellEditor;
import view.gui.tree.controller.RuTreeSelectionListener;
import view.gui.tree.model.RuTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class RuTree extends JTree {

    public RuTree(RuTreeNode root) {

        RuTreeCellRenderer treeCellRenderer = new RuTreeCellRenderer();

        setModel(new DefaultTreeModel(root));
        setCellEditor(new RuTreeCellEditor(this, treeCellRenderer));
        addTreeSelectionListener(new RuTreeSelectionListener());
        setCellRenderer(treeCellRenderer);
        setEditable(true);
    }
}
