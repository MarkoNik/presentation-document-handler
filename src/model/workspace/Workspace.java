package model.workspace;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;

public class Workspace extends RuNodeComposite {
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
    }
}
