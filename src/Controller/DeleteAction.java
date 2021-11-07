package controller;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Slide;
import model.workspace.Workspace;
import view.MainFrame;
import view.gui.tree.model.RuTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeleteAction extends AbstractRudokAction {

    public DeleteAction() {
        putValue(SMALL_ICON, loadIcon("icons/delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        RuTreeNode viewNode = (RuTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
        RuNode modelNode = viewNode.getNode();

        if (!(modelNode instanceof Workspace)) {
            RuNode modelParent = modelNode.getParent();
            RuTreeNode viewParent = (RuTreeNode) viewNode.getParent();

            ((RuNodeComposite) modelParent).removeChild(modelNode);
            viewParent.remove(viewNode);

            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
        }

        else {
            //TODO error ne moze delete Workspace
        }

    }
}
