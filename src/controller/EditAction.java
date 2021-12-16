package controller;

import view.MainFrame;
import view.workspace.PresentationView;

import java.awt.event.ActionEvent;

public class EditAction extends AbstractRudokAction {

    public EditAction() {
        putValue(SMALL_ICON, loadIcon("icons/edit.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Edit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((PresentationView) MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedComponent())
                .startEdit();
    }
}
