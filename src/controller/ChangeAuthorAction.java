package controller;

import model.nodes.RuNode;
import model.workspace.Presentation;
import view.MainFrame;
import view.dialogs.ChangeAuthorDialog;
import view.dialogs.ChangeThemeDialog;
import view.gui.tree.model.RuTreeNode;

import java.awt.event.ActionEvent;

public class ChangeAuthorAction extends AbstractRudokAction {
    public ChangeAuthorAction() {
        putValue(SMALL_ICON, loadIcon("icons/changeAuthor.png"));
        putValue(NAME, "Change Author");
        putValue(SHORT_DESCRIPTION, "Change Author");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RuTreeNode viewNode = (RuTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
        RuNode node = viewNode.getNode();
        if (node instanceof Presentation) {
            ChangeAuthorDialog dialog = new ChangeAuthorDialog();
        }
    }
}
