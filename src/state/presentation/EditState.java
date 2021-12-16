package state.presentation;

import view.workspace.panels.AbstractPresentationPanel;
import view.workspace.panels.EditPanel;

public class EditState implements PresentationState {
    @Override
    public AbstractPresentationPanel initComponent() {
        return new EditPanel();
    }
}
