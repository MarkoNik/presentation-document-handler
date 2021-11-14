package controller;

import main.Main;
import model.error.ERROR;
import model.error.ErrorFactory;
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

        RuNode modelNode = viewNode.getNode();
        if (modelNode instanceof Slide) {
            ErrorFactory.generate(ERROR.ADD_CHILD_TO_SLIDE).setVisible(true);
            return;
        }

        RuNode newNode = null;
        RuTreeNode newNodeView = null;
        int childCount = 0;
        if (modelNode instanceof RuNodeComposite) {
            childCount = ((RuNodeComposite) modelNode).getMaxChild();
        }

        if (modelNode instanceof Workspace) {
            newNode = new Project("Project " + childCount, modelNode);
            MainFrame.getInstance().getProjectView().setProject((Project) newNode);

        } else if (modelNode instanceof Project) {
            newNode = new Presentation("Presentation " + childCount, modelNode, "user");

        } else if (modelNode instanceof Presentation) {
            newNode = new Slide("Slide " + childCount, modelNode, childCount);

        }

        ((RuNodeComposite) modelNode).addChild(newNode);
        RuTreeNode newViewNode = new RuTreeNode(newNode);
        viewNode.add(newViewNode);

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());


    }
}
