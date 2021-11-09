package model.nodes;

import model.message.Notification;
import observer.IPublisher;
import observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public abstract class RuNode implements IPublisher {

    private List<ISubscriber> subscribers;

    protected String name;
    protected RuNode parent;

    public RuNode(String name, RuNode parent) {
        subscribers = new ArrayList<>();

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
        for (ISubscriber sub : subscribers) {
            sub.update(notification);
        }
    }
}
