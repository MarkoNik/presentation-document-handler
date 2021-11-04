package model.nodes;

import model.nodes.RuNode;

import java.util.List;

public abstract class RuNodeComposite extends RuNode {
    protected List<RuNode> children;

    public RuNodeComposite(String name, RuNode parent) {
        super(name, parent);
    }

    public abstract void addChild(RuNode child);

    public void removeChild(RuNode child) {
        children.remove(child);
    }
}
