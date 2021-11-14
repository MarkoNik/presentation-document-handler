package controller;

import model.error.ERROR;
import model.error.ErrorFactory;
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
        if (viewNode == null) {
            ErrorFactory.generate(ERROR.NODE_NOT_SELECTED).setVisible(true);
            return;
        }

        if (! (viewNode.getNode() instanceof Presentation)) {
            ErrorFactory.generate(ERROR.PRESENTATION_NOT_SELECTED).setVisible(true);
            return;
        }

        RuNode node = viewNode.getNode();
        if (node instanceof Presentation) {
            ChangeThemeDialog dialog = new ChangeThemeDialog();


        }

    }
}
