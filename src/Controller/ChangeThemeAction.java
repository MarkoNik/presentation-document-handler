package Controller;

import View.ChangeThemeDialog;

import java.awt.event.ActionEvent;

public class ChangeThemeAction extends AbstractRudokAction {
    public ChangeThemeAction() {
        putValue(SMALL_ICON, loadIcon("icons/theme.png"));
        putValue(NAME, "Change Theme");
        putValue(SHORT_DESCRIPTION, "Change Theme");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ChangeThemeDialog temp = new ChangeThemeDialog();
    }
}
