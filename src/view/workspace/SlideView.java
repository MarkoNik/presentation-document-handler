package view.workspace;

import model.workspace.Slide;

import javax.swing.*;
import java.awt.*;

public class SlideView extends JPanel {

    private Slide slide;
    private Image backgroundImage;

    public SlideView(Slide slide, Dimension d) {
        this.slide = slide;
        setSize(d);
        setPreferredSize(d);
        setMinimumSize(d);
        setAlignmentX(CENTER_ALIGNMENT);
        this.backgroundImage = new ImageIcon(getClass()
                .getResource("v975-background-07-b-kqkr4ukm.jpg"))
                .getImage();
        backgroundImage = backgroundImage.getScaledInstance(1000, 500, Image.SCALE_SMOOTH);
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
