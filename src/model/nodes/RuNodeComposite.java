package model.nodes;

import model.message.NOTE;
import model.message.Notification;

import java.util.ArrayList;
import java.util.List;

public abstract class RuNodeComposite extends RuNode {
    protected List<RuNode> children;
    protected int maxChild = 1;

    public RuNodeComposite(String name, RuNode parent) {
        super(name, parent);
        children = new ArrayList<>();
    }

    public abstract void addChild(RuNode child);

    public void removeChild(RuNode child) {
        children.remove(child);
        notifySubscriber(new Notification(NOTE.CHILD_REMOVED, child));
    }

    public List<RuNode> getChildren() {
        return children;
    }

    public void setChildren(List<RuNode> children) {
        this.children = children;
    }

    public int getMaxChild() {
        return maxChild;
    }
}
