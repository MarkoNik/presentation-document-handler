package view.workspace;

import model.workspace.Slot;

import javax.swing.*;
import java.awt.*;

public class SlotView extends JPanel {

    private Slot slot;

    public SlotView(Slot slot) {
        this.slot = slot;
    }

    public void paint(Graphics2D g) {

        g.setStroke(slot.getStroke());
        Point pos = slot.getPosition();
        int x = pos.x, y = pos.y;
        Dimension d = slot.getSize();
        int w = d.width, h = d.height;
        g.setPaint(slot.getColor());
        g.fillRect(x, y, w, h);

        g.setPaint(Color.WHITE);
        g.drawRect(x, y, w, h);
    }

    public boolean elementAt(Point p) {

        Point pos = slot.getPosition();
        int x = pos.x, y = pos.y;
        Dimension d = slot.getSize();
        int w = d.width, h = d.height;

        return x <= p.x && p.x <= x + w && y <= p.y && p.y <= y + h;
    }
}
