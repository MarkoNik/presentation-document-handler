package model.workspace;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import observer.IPublisher;
import observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class Workspace extends RuNodeComposite implements IPublisher {

    private List<ISubscriber> subscribers;

    public Workspace(String name, RuNode parent) {
        super(name, parent);
    }


    @Override
    public void addChild(RuNode child) {
        if (child instanceof Project) {
            children.add(child);
        } else {
            System.err.println("Prosledjujes pogresnu stvar");
        }
        maxChild++;
    }

    @Override
    public void addSubscriber(ISubscriber sub) {

        if (sub == null) {
            return;
        }
        if (subscribers == null) {
            subscribers = new ArrayList<>();
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
    public void notifySubscriber(Object notification) {
        for (ISubscriber sub : subscribers) {
            sub.update(notification);
        }
    }
}
