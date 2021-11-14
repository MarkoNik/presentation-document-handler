package model.workspace;

import model.message.NOTE;
import model.message.Notification;
import model.nodes.RuNode;
import model.nodes.RuNodeComposite;

public class Project extends RuNodeComposite {

    public Project(String name, RuNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(RuNode child) {
        if (child instanceof Presentation) {
            children.add(child);
            notifySubscriber(new Notification(NOTE.CHILD_ADDED, child));
        } else {
            System.err.println("Prosledjujes pogresnu stvar");
        }
        maxChild++;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        notifySubscriber(new Notification(NOTE.NAME_CHANGED, name));
    }
}
