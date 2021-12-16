package state.slot;

import model.workspace.Slide;
import model.workspace.Slot;
import view.workspace.SlideView;
import view.workspace.SlotView;

import java.awt.event.MouseEvent;

public class DeleteState extends SlotState {
    @Override
    public void mouseClick(MouseEvent e, SlideView slide) {

        SlotView slotView = null;
        for (SlotView sw : slide.getSlotViewList()) {
            if (sw.elementAt(e.getPoint()))
                slotView = sw;
        }

        if (slotView == null) return;
        Slide s = slide.getSlide();
        s.removeSlot(slotView.getSlot());
    }
}
