package model.factory;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import model.workspace.Slide;

public class SlideFactory extends RuNodeFactory {
    @Override
    public RuNode createNode(RuNodeComposite parent) {
        return new Slide("Slide" + (parent.getMaxChild() + 1), parent, parent.getMaxChild() + 1);
    }
}
