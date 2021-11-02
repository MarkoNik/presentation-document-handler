package Controller;

import View.ChangeAuthorDialog;
import View.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ChangeAuthorAction extends AbstractRudokAction {
    public ChangeAuthorAction() {
        putValue(SMALL_ICON, loadIcon("icons/changeAuthor.png"));
        putValue(NAME, "Change Author");
        putValue(SHORT_DESCRIPTION, "Change Author");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ChangeAuthorDialog temp = new ChangeAuthorDialog();
    }
}
