package command;

import model.nodes.RuNode;
import view.MainFrame;
import view.gui.tree.model.RuTreeNode;

import javax.swing.*;

public class RenameCommand implements ICommand {

    private RuTreeNode viewNode;
    private RuNode node;
    private String name, newName;

    public RenameCommand(RuTreeNode viewNode, String newName) {
        this.viewNode = viewNode;
        node = viewNode.getNode();
        this.newName = newName;
    }

    @Override
    public void doCommand() {
        name = viewNode.getName();
        viewNode.setName(newName);
        node.setName(newName);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
    }

    @Override
    public void undoCommand() {
        viewNode.setName(name);
        node.setName(name);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
    }
}
