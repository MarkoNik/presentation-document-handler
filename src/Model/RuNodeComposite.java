package Model;

import java.util.List;

public abstract class RuNodeComposite extends RuNode {
    protected List<RuNode> children;

    public RuNodeComposite(String name, RuNode parent) {
        super(name, parent);
    }

    public void addChild(RuNode child) {
        children.add(child);
    }

    public void removeChild(RuNode child) {
        children.remove(child);
    }
}
