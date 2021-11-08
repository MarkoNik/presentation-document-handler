package model.workspace;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import observer.IPublisher;
import observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class Project extends RuNodeComposite {

    public Project(String name, RuNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(RuNode child) {
        if (child instanceof Presentation) {
            children.add(child);
            notifySubscriber(child);
        } else {
            System.err.println("Prosledjujes pogresnu stvar");
        }
        maxChild++;
    }



}
