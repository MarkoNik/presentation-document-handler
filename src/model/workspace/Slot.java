package model.workspace;

import java.awt.*;

public class Slot {

    public static final Dimension slotDimension = new Dimension(100, 50);
    private Point position;
    private Dimension size;
    private Color color;
    private Stroke stroke;

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
}
