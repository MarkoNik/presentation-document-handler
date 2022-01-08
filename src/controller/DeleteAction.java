package controller;

import command.AddCommand;
import command.DeleteCommand;
import model.error.ERROR;
import model.error.ErrorFactory;
import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import model.workspace.Workspace;
import view.MainFrame;
import view.gui.tree.model.RuTreeNode;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;

public class DeleteAction extends AbstractRudokAction {

    public DeleteAction() {
        putValue(SMALL_ICON, loadIcon("icons/delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // error check
        RuTreeNode viewNode = (RuTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
        if (viewNode == null) {
            ErrorFactory.generate(ERROR.NODE_NOT_SELECTED).setVisible(true);
            return;
        }
        RuNode modelNode = viewNode.getNode();
        if (modelNode instanceof Workspace) {
            ErrorFactory.generate(ERROR.DELETE_WORKSPACE).setVisible(true);
            return;
        }

        MainFrame.getInstance().getCommandManager().addCommand(new DeleteCommand(viewNode));

    }
}
