package model.factory;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import model.workspace.Presentation;
import model.workspace.Project;

public class PresentationFactory extends RuNodeFactory {
    @Override
    public RuNode createNode(RuNodeComposite parent) {
        return new Presentation("Presentation" + (parent.getMaxChild() + 1), parent, "user");
    }
}
