package controller;

import model.workspace.Presentation;
import view.MainFrame;
import view.workspace.PresentationView;

import java.awt.event.ActionEvent;

public class CreateSlotAction extends AbstractRudokAction {


    public CreateSlotAction() {
        putValue(SMALL_ICON, loadIcon("icons/createSlot.png"));
        putValue(NAME, "Create slot");
        putValue(SHORT_DESCRIPTION, "Create slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((PresentationView) MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedComponent())
                .getStateManager().setAddState();
    }
}
