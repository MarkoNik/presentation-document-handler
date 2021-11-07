package controller;

import main.Main;
import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Slide;
import model.workspace.Workspace;
import view.MainFrame;
import view.gui.tree.controller.RuTreeSelectionListener;
import view.gui.tree.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;

public class NewAction extends AbstractRudokAction {

    public NewAction() {
        putValue(SMALL_ICON, loadIcon("icons/plus.png"));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "New");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MyTreeNode viewNode = (MyTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();

        // expanduje samo kad dodam drugo dete?
        MainFrame.getInstance().getTree().expandPath(MainFrame.getInstance().getTree().getSelectionPath());

        RuNode modelNode = viewNode.getNode();
        int childCount = 0;
        RuNode newNode = null;


        if (modelNode instanceof RuNodeComposite) {
            childCount = ((RuNodeComposite) modelNode).getChildren().size();
            childCount++;
        }

        if (modelNode instanceof Workspace) {
            newNode = new Project("Project " + childCount, modelNode);

        } else if (modelNode instanceof Project) {
            newNode = new Presentation("Presentation " + childCount, modelNode, "user");

        } else if (modelNode instanceof Presentation) {
            newNode = new Slide("Slide " + childCount, modelNode, childCount);

        }

        if (newNode != null) {
            ((RuNodeComposite) modelNode).addChild(newNode);
            viewNode.add(new MyTreeNode(newNode));
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
        }

        else {
            //TODO error
        }

    }
}
