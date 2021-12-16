package state.presentation;

import view.workspace.panels.AbstractPresentationPanel;
import view.workspace.panels.EditPanel;
import view.workspace.panels.SlideShowPanel;

public class SlideShowState implements PresentationState {
    @Override
    public AbstractPresentationPanel initComponent() {
        return new SlideShowPanel();
    }
}
