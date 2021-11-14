package controller;

import model.error.ERROR;
import model.error.ErrorFactory;
import model.nodes.RuNode;
import model.workspace.Presentation;
import view.MainFrame;
import view.dialogs.ChangeAuthorDialog;
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
        if (! (viewNode.getNode() instanceof Presentation)) {
            ErrorFactory.generate(ERROR.PRESENTATION_NOT_SELECTED).setVisible(true);
            return;
        }

        RuNode node = viewNode.getNode();
        if (node instanceof Presentation) {
            ChangeAuthorDialog dialog = new ChangeAuthorDialog();
        }
    }
}
