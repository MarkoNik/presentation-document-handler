package view.workspace;

import controller.listeners.SlideMouseListener;
import model.message.NOTE;
import model.message.Notification;
import model.workspace.Slide;
import model.workspace.Slot;
import observer.ISubscriber;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class SlideView extends JPanel implements ISubscriber {

    private Slide slide;
    private Image backgroundImage;
    private List<SlotView> slotViewList;
    private PresentationView presentationView;

    public SlideView(Slide slide, Dimension d, Image backgroundImage, PresentationView presentationView) {

        slotViewList = new ArrayList<>();
        for (Slot slot : slide.getSlots()) {
            slotViewList.add(new SlotView(slot));
            slot.addSubscriber(this);
        }
        this.slide = slide;
        this.backgroundImage = backgroundImage;
        setSize(d);
        setPreferredSize(d);
        setMinimumSize(d);
        setMaximumSize(d);
        slide.addSubscriber(this);
        setAlignmentX(CENTER_ALIGNMENT);
        this.presentationView = presentationView;

        SlideMouseListener slideMouseListener = new SlideMouseListener(this);
        addMouseListener(slideMouseListener);
        addMouseMotionListener(slideMouseListener);
    }

    public Slide getSlide() {
        return slide;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
        for (SlotView s : slotViewList) {
            s.paint(g2d);
        }
    }

    @Override
    public void update(Notification notification) {

        NOTE note = notification.getType();
        Slot slot = (Slot) notification.getPayload();
        switch (note) {
            case SLOT_ADDED -> {
                slot.addSubscriber(this);
                SlotView slotView = new SlotView(slot);
                slotViewList.add(slotView);
            }
            case SLOT_DELETED -> {
                slot.removeSubscriber(this);
                int i = 0;
                for (SlotView sw : slotViewList) {
                    if (sw.getSlot() == slot) {
                        break;
                    }
                    i++;
                }
                slotViewList.remove(i);
            }
        }

        repaint();
    }

    public PresentationView getPresentationView() {
        return presentationView;
    }

    public List<SlotView> getSlotViewList() {
        return slotViewList;
    }
}
