package state.slot;

import view.workspace.SlideView;
import view.workspace.SlotView;

import java.awt.event.MouseEvent;

public class DeleteState extends SlotState {
    @Override
    public void mouseClick(MouseEvent e, SlideView slideView) {
        SlotView sv = clickedSlotView(e, slideView);
        slideView.getSlide().removeSlot(sv.getSlot());
    }
}
