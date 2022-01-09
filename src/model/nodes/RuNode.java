package model.nodes;

import model.message.Notification;
import observer.IPublisher;
import observer.ISubscriber;

import javax.swing.event.EventListenerList;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class RuNode implements IPublisher, Serializable {

    protected transient List<ISubscriber> subscribers = new ArrayList<>();

    protected String name;
    protected RuNode parent;
    private transient boolean changed;

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


    @Override
    public void addSubscriber(ISubscriber sub) {

        if (sub == null) {
            return;
        }

        if (subscribers.contains(sub)) {
            return;
        }

        subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        subscribers.remove(sub);
    }

    @Override
    public void notifySubscriber(Notification notification) {
        setChanged(true);
        for (ISubscriber sub : subscribers) {
            sub.update(notification);
        }
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public boolean isChanged() {
        return changed;
    }
}
