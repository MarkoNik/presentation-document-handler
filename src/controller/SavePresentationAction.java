package controller;

import controller.filters.PresentationFileFilter;
import model.error.ERROR;
import model.error.ErrorFactory;
import model.workspace.Presentation;
import model.workspace.Slide;
import view.MainFrame;
import view.gui.tree.model.RuTreeNode;
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
        RuTreeNode viewNode = (RuTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
        if (! (viewNode.getNode() instanceof Presentation)) {
            ErrorFactory.generate(ERROR.PRESENTATION_NOT_SELECTED).setVisible(true);
            return;
        }

        Presentation presentation = (Presentation) viewNode.getNode();
        if (!presentation.isChanged()) return;
        File presentationFile = presentation.getPresentationFile();

        if (presentationFile == null) {

            if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION)
                presentationFile = jfc.getSelectedFile();

            else return;
        }

        ObjectOutputStream os;
        try {
            String name = presentationFile.getName();
            File f = new File(presentationFile.getParent(), name + ".pnf");
            os = new ObjectOutputStream(new FileOutputStream(f));
            os.writeObject(presentation);
            presentation.setPresentationFile(f);
            presentation.setChanged(false);

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
