package controller;

import view.MainFrame;
import view.workspace.PresentationView;

import java.awt.event.ActionEvent;

public class DeleteSlotAction extends AbstractRudokAction {

    public DeleteSlotAction() {
        putValue(SMALL_ICON, loadIcon("icons/deleteSlot.png"));
        putValue(NAME, "Delete slot");
        putValue(SHORT_DESCRIPTION, "Delete slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((PresentationView) MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedComponent())
                .startDeleteSlot();
    }
}
