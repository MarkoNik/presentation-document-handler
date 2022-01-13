package model.workspace;

import model.content.Type;
import model.message.NOTE;
import model.message.Notification;
import observer.IPublisher;
import observer.ISubscriber;
import serialization.SerializableStrokeAdapter;

import java.awt.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Slot implements IPublisher, Serializable {

    public static final Dimension slotDimension = new Dimension(200, 150);
    private Point position;
    private Dimension size;
    private Color color;
    private SerializableStrokeAdapter stroke;
    private boolean selected;
    private String content;
    private Type type;
    private transient List<ISubscriber> subscribers = new ArrayList<>();

    public Slot(Point position, Dimension size, Color color, SerializableStrokeAdapter stroke, Type type) {

        this.position = position;
        this.size = size;
        this.color = color;
        this.stroke = stroke;
        this.type = type;
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

    public SerializableStrokeAdapter getStroke() {
        return stroke;
    }

    public void setStroke(SerializableStrokeAdapter stroke) {
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

    @Serial
    private Object readResolve(){
        subscribers = new ArrayList<>();
        return this;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifySubscriber(new Notification(NOTE.CONTENT_UPDATED, content));
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setSubscribers(List<ISubscriber> subscribers) {
        this.subscribers = subscribers;
    }
}
