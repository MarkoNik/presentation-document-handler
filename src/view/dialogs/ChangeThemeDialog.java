package view.dialogs;

import view.MainFrame;

import javax.swing.*;

public class ChangeThemeDialog extends JDialog {
    public ChangeThemeDialog() {
        super(MainFrame.getInstance(), "Change Theme", true);


        setVisible(true);
    }
}
