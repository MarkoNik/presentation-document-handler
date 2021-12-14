package view.workspace;

import controller.SlideMouseListener;
import model.message.Notification;
import model.workspace.Slide;
import observer.ISubscriber;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class SlideView extends JPanel implements ISubscriber {

    private Slide slide;
    private Image backgroundImage;
    private List <SlotView> slotViewList;
    private SlideMouseListener listener;

    public SlideView(Slide slide, Dimension d, Image backgroundImage) {
        listener = new SlideMouseListener(this);
        slotViewList = new ArrayList<>();
        this.slide = slide;
        this.backgroundImage = backgroundImage;
        setSize(d);
        setPreferredSize(d);
        setMinimumSize(d);
        setMaximumSize(d);
        slide.addSubscriber(this);
        setAlignmentX(CENTER_ALIGNMENT);
    }

    public Slide getSlide() {
        return slide;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void update(Notification notification) {

    }

    public void clicked(Point point) {

    }
}
