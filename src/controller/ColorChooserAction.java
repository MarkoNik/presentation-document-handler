package controller;

import view.MainFrame;
import view.workspace.PresentationView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ColorChooserAction extends AbstractRudokAction {
    public ColorChooserAction() {
        putValue(SMALL_ICON, loadIcon("icons/colorDialog.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Edit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = ((PresentationView) MainFrame.getInstance().getProjectView()
                .getjTabbedPane().getSelectedComponent());

        Color color = JColorChooser
                .showDialog(presentationView, "Color dialog", presentationView.getPresentation().getSlotColor());
        if (color == null) return;
        presentationView.getPresentation().setSlotColor(color);
    }
}
