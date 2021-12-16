package state.slot;

import model.workspace.Slot;
import view.workspace.SlideView;

import java.awt.*;
import java.awt.event.MouseEvent;

public class CreateState extends SlotState {
    @Override
    public void mouseClick(MouseEvent e, SlideView slideView) {

        Point pos = e.getPoint();
        Color fill = Color.GREEN;
        Slot slot = new Slot(pos, Slot.slotDimension, fill, new BasicStroke(5f));
        slideView.getSlide().addSlot(slot);
    }
}
