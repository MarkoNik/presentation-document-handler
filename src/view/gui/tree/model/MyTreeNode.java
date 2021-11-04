package view.gui.tree.model;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class MyTreeNode extends DefaultMutableTreeNode {

    String name;
    RuNode node;

    public MyTreeNode(String name, RuNode node) {
        this.name = name;
        this.node = node;
    }

    public MyTreeNode(RuNode node) {
        this.node = node;
    }

    public RuNode getNode() {
        return node;
    }

    public void setNode(RuNode node) {
        this.node = node;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}