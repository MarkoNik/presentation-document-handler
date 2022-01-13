package view.gui.tree.model;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;

import javax.swing.tree.DefaultMutableTreeNode;

public class RuTreeNode extends DefaultMutableTreeNode {

    RuNode node;

    public RuTreeNode(RuNode node) {
        this.node = node;
        if (node instanceof RuNodeComposite) {
            for (RuNode child : ((RuNodeComposite) node).getChildren()) {
                add(new RuTreeNode(child));
            }
        }
    }

    public RuNode getNode() {
        return node;
    }

    public void setNode(RuNode node) {
        this.node = node;
    }

    public String getName() {
        return node.getName();
    }

    public void setName(String name) {
        node.setName(name);
    }

    @Override
    public String toString() {
        return node.getName();
    }
}
