package model.factory;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import model.workspace.Project;

public class ProjectFactory extends RuNodeFactory {
    @Override
    public RuNode createNode(RuNodeComposite parent) {
        return new Project("Project" + (parent.getMaxChild() + 1), parent);
    }
}
