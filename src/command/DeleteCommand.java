package command;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Workspace;
import view.MainFrame;
import view.gui.tree.model.RuTreeNode;

import javax.swing.*;
import javax.swing.tree.TreePath;

public class DeleteCommand implements ICommand {

    RuNode node;
    RuNodeComposite parent;

    RuTreeNode viewNode;
    RuTreeNode viewParent;

    public DeleteCommand(RuTreeNode viewNode) {

        node = viewNode.getNode();
        parent = (RuNodeComposite) node.getParent();

        this.viewNode = viewNode;
        viewParent = (RuTreeNode) viewNode.getParent();
    }

    @Override
    public void doCommand() {
        parent.removeChild(node);
        viewParent.remove(viewNode);

        MainFrame.getInstance().getTree().setSelectionPath(new TreePath(viewParent.getPath()));

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
    }

    @Override
    public void undoCommand() {
        parent.addChild(node);
        viewParent.add(viewNode);
        MainFrame.getInstance().getTree().setSelectionPath(new TreePath(viewParent.getPath()));
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
    }
}
