package model.workspace;

import java.awt.*;

public class Slot {

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


}
