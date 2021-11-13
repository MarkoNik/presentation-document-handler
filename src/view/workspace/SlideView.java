package view.workspace;

import model.workspace.Slide;

import javax.swing.*;
import java.awt.*;

public class SlideView extends JPanel {

    private Slide slide;
    private Image backgroundImage;

    public SlideView(Slide slide, Dimension d, Image backgroundImage) {
        this.slide = slide;
        this.backgroundImage = backgroundImage;
        setSize(d);
        setPreferredSize(d);
        setMinimumSize(d);
        setMaximumSize(d);
        setAlignmentX(CENTER_ALIGNMENT);
    }

    public void setBackgroundImage(Image backgroundImage) {
        //this.backgroundImage = backgroundImage;
    }

    public Slide getSlide() {
        return slide;
    }

    public void setSlide(Slide slide) {
        this.slide = slide;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
