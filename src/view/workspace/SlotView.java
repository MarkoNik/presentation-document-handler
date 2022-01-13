package view.workspace;

import model.content.ImageContent;
import model.content.TextContent;
import model.workspace.Slot;
import view.workspace.content.ImageContentHandler;
import view.workspace.content.SlotContentHandler;
import view.workspace.content.TextContentHandler;

import javax.swing.*;
import java.awt.*;

public class SlotView extends JPanel {

    private Slot slot;
    private SlotContentHandler handler;

    public SlotView(Slot slot) {
        this.slot = slot;
        if (slot.getSlotContent() instanceof TextContent) handler = new TextContentHandler();
        if (slot.getSlotContent() instanceof ImageContent) handler = new ImageContentHandler();
    }

    public void paint(Graphics2D g) {

        g.setStroke(slot.getStroke());
        Point pos = slot.getPosition();
        int x = pos.x, y = pos.y;
        Dimension d = slot.getSize();
        int w = d.width, h = d.height;
        g.setPaint(slot.getColor());
        g.fillRect(x, y, w, h);

        g.setPaint(Color.BLACK);
        if (slot.isSelected()) g.setPaint(Color.RED);

        g.drawRect(x, y, w, h);
        if (slot.isSlideShow()) handler.draw(this, g);
    }

    public boolean elementAt(Point p) {

        Point pos = slot.getPosition();
        int x = pos.x, y = pos.y;
        Dimension d = slot.getSize();
        int w = d.width, h = d.height;

        return x <= p.x && p.x <= x + w && y <= p.y && p.y <= y + h;
    }

    public Slot getSlot() {
        return slot;
    }

    public SlotContentHandler getHandler() {
        return handler;
    }
}
