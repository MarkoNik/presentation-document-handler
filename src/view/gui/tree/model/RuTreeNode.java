package view.gui.tree.model;

import model.nodes.RuNode;

import javax.swing.tree.DefaultMutableTreeNode;

public class RuTreeNode extends DefaultMutableTreeNode {

    RuNode node;

    public RuTreeNode(RuNode node) {
        this.node = node;
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
