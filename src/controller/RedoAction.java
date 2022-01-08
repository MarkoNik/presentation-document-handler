package controller;

import view.MainFrame;
import view.workspace.PresentationView;

import java.awt.event.ActionEvent;

public class RedoAction extends AbstractRudokAction {

    public RedoAction() {
        putValue(SMALL_ICON, loadIcon("icons/redo.png"));
        putValue(NAME, "Redo");
        putValue(SHORT_DESCRIPTION, "Redo");
    }

    @Override
    public
    void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getCommandManager().doCommand();
    }
}
