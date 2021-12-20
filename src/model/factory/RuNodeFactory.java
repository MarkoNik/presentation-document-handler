package model.factory;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Workspace;

public abstract class RuNodeFactory {

    public RuNode createChild(RuNodeComposite node) {
        return createNode(node);
    }

    public abstract RuNode createNode(RuNodeComposite parent);

    public static RuNodeFactory getFactory(Class<? extends RuNodeComposite> type) {
        if (Workspace.class.equals(type)) {
            return new ProjectFactory();
        } else if (Project.class.equals(type)) {
            return new PresentationFactory();
        } else if (Presentation.class.equals(type)) {
            return new SlideFactory();
        }
        return null;
    }
}
