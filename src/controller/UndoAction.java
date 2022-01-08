package controller;

import view.MainFrame;
import view.workspace.PresentationView;

import java.awt.event.ActionEvent;

public class UndoAction extends AbstractRudokAction {

    public UndoAction() {
        putValue(SMALL_ICON, loadIcon("icons/undo.png"));
        putValue(NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "Undo");
    }

    @Override
    public
    void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getCommandManager().undoCommand();
    }
}
