package controller;

import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class InfoAction extends AbstractRudokAction {

    public InfoAction() {
        putValue(SMALL_ICON, loadIcon("icons/questionmark.png"));
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Info");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(MainFrame.getInstance(), "Marko Nikacevic 16/20RN");
    }
}
