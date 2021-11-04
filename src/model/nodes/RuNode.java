package model.nodes;

public abstract class RuNode {
    protected String name;
    protected RuNode parent;

    public RuNode(String name, RuNode parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RuNode getParent() {
        return parent;
    }

    public void setParent(RuNode parent) {
        this.parent = parent;
    }
}
