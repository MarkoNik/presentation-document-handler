package controller;

import model.error.ERROR;
import model.error.ErrorFactory;
import model.factory.RuNodeFactory;
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

public class NewAction extends AbstractRudokAction {

    public NewAction() {
        putValue(SMALL_ICON, loadIcon("icons/plus.png"));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "New");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        RuTreeNode viewNode = (RuTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
        if (viewNode == null) {
            ErrorFactory.generate(ERROR.NODE_NOT_SELECTED).setVisible(true);
            return;
        }

        // expanduje samo kad dodam drugo dete?
        MainFrame.getInstance().getTree().expandPath(MainFrame.getInstance().getTree().getSelectionPath());

        if (viewNode.getNode() instanceof Slide) {
            ErrorFactory.generate(ERROR.ADD_CHILD_TO_SLIDE).setVisible(true);
            return;
        }

        RuNodeComposite modelNode = (RuNodeComposite) viewNode.getNode();
        RuNode newNode = RuNodeFactory.getFactory(modelNode.getClass()).createNode(modelNode);
        modelNode.addChild(newNode);
        RuTreeNode newViewNode = new RuTreeNode(newNode);
        viewNode.add(newViewNode);

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());


    }
}
