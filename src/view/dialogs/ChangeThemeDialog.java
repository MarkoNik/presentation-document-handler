package view.dialogs;

import model.workspace.Presentation;
import view.MainFrame;
import view.gui.tree.model.RuTreeNode;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;

public class ChangeThemeDialog {
    public ChangeThemeDialog() {
        File currentDirFile = new File(".");
        String helper = currentDirFile.getAbsolutePath();
        String currentDir = helper.substring(0, helper.length() - 1);

        JFileChooser chooser = new JFileChooser(currentDir + "src\\view\\workspace\\themes");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(MainFrame.getInstance());
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getPath());
        }
        RuTreeNode viewNode = (RuTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
        Presentation p = (Presentation) viewNode.getNode();
        // String path = chooser.getSelectedFile().getPath();
        // path = fixPath(path);
        // p.setBackgroundPath(path);
        String path = chooser.getSelectedFile().getName();
        p.setBackgroundPath(path);
    }

    private String fixPath(String path) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            tmp.append(path.charAt(i));
            if (path.charAt(i) == '\\') {
                tmp.append(path.charAt(i));
            }
        }
        return tmp.toString();
    }
}
