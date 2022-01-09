package controller;

import controller.filters.PresentationFileFilter;
import model.workspace.Presentation;
import view.MainFrame;
import view.workspace.PresentationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class SavePresentationAction extends AbstractRudokAction {

    public SavePresentationAction() {
        putValue(SMALL_ICON, loadIcon("icons/save.png"));
        putValue(NAME, "Save presentation");
        putValue(SHORT_DESCRIPTION, "Save presentation");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new PresentationFileFilter());
        Presentation presentation = ((PresentationView) (MainFrame
                                                            .getInstance()
                                                            .getProjectView()
                                                            .getjTabbedPane()
                                                            .getSelectedComponent()))
                                                            .getPresentation();
        if (!presentation.isChanged()) return;
        File presentationFile = presentation.getPresentationFile();

        if (presentationFile == null) {

            if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION)
                presentationFile = jfc.getSelectedFile();

            else return;
        }

        ObjectOutputStream os;
        try {
            os = new ObjectOutputStream(new FileOutputStream(presentationFile));
            os.writeObject(presentation);
            presentation.setPresentationFile(presentationFile);
            presentation.setChanged(false);

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
