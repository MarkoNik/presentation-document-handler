package controller;

import controller.filters.TextFileFilter;
import model.workspace.Project;
import model.workspace.Workspace;
import view.MainFrame;
import view.gui.tree.model.RuTreeNode;
import view.gui.tree.view.RuTree;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Scanner;

public class OpenWorkspaceAction extends AbstractRudokAction {
    public OpenWorkspaceAction() {
        putValue(SMALL_ICON, loadIcon("icons/open.png"));
        putValue(NAME, "Open workspace");
        putValue(SHORT_DESCRIPTION, "Open workspace");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new TextFileFilter());

        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            try {

                // brise trenutni workspace
                RuTree rt = MainFrame.getInstance().getTree();
                TreeModel model = new DefaultTreeModel(new RuTreeNode(new Workspace("Workspace", null)));
                rt.setModel(model);
                RuTreeNode root = (RuTreeNode) rt.getModel().getRoot();
                Workspace workspace = (Workspace) root.getNode();


                Scanner sc = new Scanner(jfc.getSelectedFile());
                while (sc.hasNext()) {

                    String filePath = sc.nextLine();
                    File projectFile = new File(filePath);
                    ObjectInputStream os = new ObjectInputStream(new FileInputStream(projectFile));
                    Project project;
                    try {
                        project = (Project) os.readObject();
                        RuTreeNode projectNode = new RuTreeNode(project);
                        workspace.addChild(project);
                        root.add(projectNode);

                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }

                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
