package view.workspace.panels;

import model.workspace.Slide;
import view.workspace.SlideView;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractPresentationPanel extends JPanel implements PresentationPanel {

    protected int indexOfSlide(Slide slide, JPanel jPanel) {
        int index = 0;
        for (Component c : jPanel.getComponents()) {

            if (!(c instanceof SlideView tmp)) continue;
            if (tmp.getSlide().getId() == slide.getId()) {
                slide.removeSubscriber(tmp);
                break;
            }
            index++;
        } return index;
    }
}
