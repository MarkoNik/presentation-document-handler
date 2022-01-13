package controller;

import controller.filters.PresentationFileFilter;
import controller.filters.ProjectFileFilter;
import model.error.ERROR;
import model.error.ErrorFactory;
import model.error.UserError;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Workspace;
import view.MainFrame;
import view.gui.tree.model.RuTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OpenProjectAction  extends AbstractRudokAction {

    public OpenProjectAction() {
        putValue(SMALL_ICON, loadIcon("icons/open.png"));
        putValue(NAME, "Open project");
        putValue(SHORT_DESCRIPTION, "Open project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new ProjectFileFilter());
        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {

            try {
                ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
                Project project = null;
                try {
                    project = (Project) os.readObject();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }

                RuTreeNode selected = ((RuTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent());
                if (!(selected.getNode() instanceof Workspace))
                {
                    ErrorFactory.generate(ERROR.WORKSPACE_NOT_SELECTED).setVisible(true);
                    return;
                }

                ((Workspace) selected.getNode()).addChild(project);
                selected.add(new RuTreeNode(project));
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
