package controller;

import model.nodes.RuNode;
import model.workspace.Project;
import model.workspace.Workspace;
import view.MainFrame;
import view.gui.tree.model.RuTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveWorkspaceAction  extends AbstractRudokAction {

    public SaveWorkspaceAction() {
        putValue(SMALL_ICON, loadIcon("icons/save.png"));
        putValue(NAME, "Save workspace");
        putValue(SHORT_DESCRIPTION, "Save workspace");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        RuTreeNode viewNode = (RuTreeNode) MainFrame.getInstance().getTree().getModel().getRoot();
        Workspace workspace = (Workspace) viewNode.getNode();
        File workspaceDirectory = workspace.getWorkspaceDirectory();

        if (workspaceDirectory == null) {

            if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION)
                workspaceDirectory = jfc.getSelectedFile();

            else return;
        }


        // automatski cuva sve projektne fajlove u jednom workspace direktorijumu
        // lako moze da se promeni da cuva projekte na originalnim lokacijama ako su cuvani pre
        List<File> projectList = new ArrayList<>();
        for (RuNode node : workspace.getChildren()) {
            Project project = (Project) node;

            File projectFile = null;
            try {
                projectFile = new File(workspaceDirectory.getCanonicalPath() + "\\" + project.getName() + ".pjf");
            } catch (IOException ex) {
                ex.printStackTrace();
            }


            ObjectOutputStream os;
            try {
                os = new ObjectOutputStream(new FileOutputStream(projectFile));
                os.writeObject(project);
                project.setProjectFile(projectFile);
                project.setChanged(false);
                projectList.add(projectFile);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }


        FileWriter fw;
        try {
            File f = new File(workspaceDirectory.getCanonicalPath() + "\\Workspace.txt");
            fw = new FileWriter(f);
            for (File project : projectList) {
                fw.write(project.getCanonicalPath());
                fw.write('\n');
            }
            fw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
