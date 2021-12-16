package controller;

import view.MainFrame;
import view.workspace.PresentationView;

import java.awt.event.ActionEvent;

public class MoveSlotAction extends AbstractRudokAction {

    public MoveSlotAction() {
        putValue(SMALL_ICON, loadIcon("icons/moveSlot.png"));
        putValue(NAME, "Move slot");
        putValue(SHORT_DESCRIPTION, "Move slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((PresentationView) MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedComponent())
                .startMoveSlot();
    }
}
