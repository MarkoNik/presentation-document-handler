package controller;

import model.nodes.RuNode;
import model.workspace.Presentation;
import view.MainFrame;
import view.dialogs.ChangeThemeDialog;
import view.gui.tree.model.RuTreeNode;

import java.awt.event.ActionEvent;

public class ChangeThemeAction extends AbstractRudokAction {
    public ChangeThemeAction() {
        putValue(SMALL_ICON, loadIcon("icons/theme.png"));
        putValue(NAME, "Change Theme");
        putValue(SHORT_DESCRIPTION, "Change Theme");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RuTreeNode viewNode = (RuTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
        RuNode node = viewNode.getNode();
        if (node instanceof Presentation) {

            ChangeThemeDialog dialog = new ChangeThemeDialog();


        } else {
            //TODO error
        }

    }
}
