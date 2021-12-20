package view.workspace.panels;

import model.workspace.Slide;
import view.workspace.SlideView;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractPresentationPanel extends JPanel implements PresentationPanel {

    protected int indexOfSlide(Slide slide, JPanel jPanel) {
        int index = -1;
        for (Component c : jPanel.getComponents()) {

            index++;
            if (!(c instanceof SlideView)) continue;
            SlideView slideView = (SlideView) c;
            if (slideView.getSlide().getId() == slide.getId()) {
                break;
            }
        }
        return index;
    }
}
