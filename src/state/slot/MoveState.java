package state.slot;

import model.workspace.Presentation;
import model.workspace.Slot;
import view.workspace.SlideView;
import view.workspace.SlotView;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MoveState extends SlotState {

    private int offsetX = 0, offsetY = 0;
    public void mouseClick(MouseEvent e, SlideView slideView) {

        SlotView slotView = clickedSlotView(e, slideView);
        if (((Presentation) slideView.getSlide().getParent()).getSelectedSlot() != null) {
            ((Presentation) slideView.getSlide().getParent()).getSelectedSlot().setSelected(false);
        }
        if (slotView != null) {
            slotView.getSlot().setSelected(true);
            ((Presentation) slideView.getSlide().getParent()).setSelectedSlot(slotView.getSlot());
            offsetX = e.getX() - slotView.getSlot().getPosition().x;
            offsetY = e.getY() - slotView.getSlot().getPosition().y;
            if (e.getClickCount() == 2) {
                slotView.getHandler().edit(slotView);
            }

            return;
        }

        ((Presentation) slideView.getSlide().getParent()).setSelectedSlot(null);
    }

    @Override
    public void mouseDrag(MouseEvent e, SlideView slideView) {
        Slot selected = slideView.getPresentationView().getPresentation().getSelectedSlot();
        if (selected == null) return;
        selected.setPosition(new Point(e.getX() - offsetX, e.getY() - offsetY));
    }
}
