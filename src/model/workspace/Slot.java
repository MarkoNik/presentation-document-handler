package model.workspace;

import model.message.NOTE;
import model.message.Notification;
import observer.IPublisher;
import observer.ISubscriber;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Slot implements IPublisher {

    public static final Dimension slotDimension = new Dimension(100, 50);
    private Point position;
    private Dimension size;
    private Color color;
    private Stroke stroke;
    private boolean selected;
    private List<ISubscriber> subscribers = new ArrayList<>();

    public Slot(Point position, Dimension size, Color color, Stroke stroke) {

        this.position = position;
        this.size = size;
        this.color = color;
        this.stroke = stroke;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
        notifySubscriber(new Notification(NOTE.SLOT_MOVED, this));
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        notifySubscriber(new Notification(NOTE.SLOT_SELECTED, this));
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        subscribers.remove(sub);
    }

    @Override
    public void notifySubscriber(Notification notification) {
        for (ISubscriber subscriber : subscribers) {
            subscriber.update(notification);
        }
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }
}
