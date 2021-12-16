package state.slot;

import model.workspace.Slide;
import view.workspace.SlideView;
import view.workspace.SlotView;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class SlotState {
    public void mouseClick(MouseEvent e, SlideView slideView) { }
    public void mouseDrag(MouseEvent e, SlideView slideView) { }

    protected SlotView clickedSlotView(MouseEvent e, SlideView slideView) {
        SlotView slotView = null;
        for (SlotView sw : slideView.getSlotViewList()) {
            if (sw.elementAt(e.getPoint()))
                slotView = sw;
        }

        return slotView;
    }
}
