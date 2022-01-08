package command;

import model.factory.RuNodeFactory;
import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Workspace;
import view.MainFrame;
import view.gui.tree.model.RuTreeNode;

import javax.swing.*;
import javax.swing.tree.TreePath;

public class AddCommand implements ICommand {

    private RuNodeComposite node;
    private RuNode child;

    private RuTreeNode viewNode;
    private RuTreeNode viewChild;

    public AddCommand(RuTreeNode viewNode) {
        this.viewNode = viewNode;
        this.node = (RuNodeComposite) viewNode.getNode();
        child = RuNodeFactory.getFactory(node.getClass()).createNode(node);
        viewChild = new RuTreeNode(child);
    }

    @Override
    public void doCommand() {
        node.addChild(child);
        viewNode.add(viewChild);
        MainFrame.getInstance().getTree().setSelectionPath(new TreePath(viewNode.getPath()));
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
    }

    @Override
    public void undoCommand() {
        MainFrame.getInstance().getTree().setSelectionPath(new TreePath(viewChild.getPath()));
        node.removeChild(child);
        viewNode.remove(viewChild);

        // zli selection hak?
        if (node instanceof Presentation) {
            MainFrame.getInstance().getTree().setSelectionPath(new TreePath(viewNode.getParent()));
        }

        MainFrame.getInstance().getTree().setSelectionPath(new TreePath(viewNode.getPath()));
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
    }
}
