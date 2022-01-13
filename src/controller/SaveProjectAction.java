package controller;

import controller.filters.PresentationFileFilter;
import controller.filters.ProjectFileFilter;
import model.error.ERROR;
import model.error.ErrorFactory;
import model.workspace.Presentation;
import model.workspace.Project;
import view.MainFrame;
import view.gui.tree.model.RuTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveProjectAction extends AbstractRudokAction {

    public SaveProjectAction() {
        putValue(SMALL_ICON, loadIcon("icons/save.png"));
        putValue(NAME, "Save project");
        putValue(SHORT_DESCRIPTION, "Save project");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new ProjectFileFilter());
        RuTreeNode viewNode = (RuTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
        if (! (viewNode.getNode() instanceof Project)) {
            ErrorFactory.generate(ERROR.PROJECT_NOT_SELECTED).setVisible(true);
            return;
        }

        Project project = (Project) viewNode.getNode();
        if (!project.isChanged()) return;
        File projectFile = project.getProjectFile();

        if (projectFile == null) {

            if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION)
                projectFile = jfc.getSelectedFile();

            else return;
        }

        ObjectOutputStream os;
        try {
            String name = projectFile.getName();
            File f = new File(projectFile.getParent(), name + ".pjf");
            os = new ObjectOutputStream(new FileOutputStream(f));
            os.writeObject(project);
            project.setProjectFile(f);
            project.setChanged(false);

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
