package controller;

import controller.filters.PresentationFileFilter;
import model.workspace.Presentation;
import model.workspace.Project;
import view.MainFrame;
import view.gui.tree.model.RuTreeNode;
import view.workspace.PresentationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class OpenPresentationAction extends AbstractRudokAction {

    public OpenPresentationAction() {
        putValue(SMALL_ICON, loadIcon("icons/open.png"));
        putValue(NAME, "Open presentation");
        putValue(SHORT_DESCRIPTION, "Open presentation");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new PresentationFileFilter());
        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {

            try {
                ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
                Presentation presentation = null;
                try {
                    presentation = (Presentation) os.readObject();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }

                RuTreeNode selected = ((RuTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent());
                if (!(selected.getNode() instanceof Project)) return; // TODO ERR

                ((Project) selected.getNode()).addChild(presentation);
                selected.add(new RuTreeNode(presentation));
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
