package view.gui.tree.view;

import model.workspace.Project;
import model.workspace.Workspace;
import view.gui.tree.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class RuTreeCellRenderer extends DefaultTreeCellRenderer {

    public RuTreeCellRenderer() {
    }

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row, hasFocus);

        if (((MyTreeNode)value).getNode() instanceof Workspace) {
            URL imageURL = getClass().getResource("icons/tdiagram.gif");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);

        } else if (((MyTreeNode)value).getNode() instanceof Project) {
            URL imageURL = getClass().getResource("icons/tproject.gif");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);
        }
        return this;
    }
}
