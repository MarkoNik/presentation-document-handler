package view.workspace.content;

import view.workspace.SlotView;

import java.awt.*;

public interface SlotContentHandler {
    void draw(SlotView slotView, Graphics2D g);
    void edit(SlotView slotView);
}
