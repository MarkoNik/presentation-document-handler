package state.slot;

import model.content.Type;
import model.workspace.Presentation;
import model.workspace.Slot;
import serialization.SerializableStrokeAdapter;
import view.MainFrame;
import view.workspace.PresentationView;
import view.workspace.SlideView;

import java.awt.*;
import java.awt.event.MouseEvent;

public class CreateState extends SlotState {
    @Override
    public void mouseClick(MouseEvent e, SlideView slideView) {

        Point pos = e.getPoint();
        PresentationView presentationView = (PresentationView) MainFrame.getInstance().getProjectView()
                .getjTabbedPane().getSelectedComponent();
        Presentation presentation = presentationView.getPresentation();

        Color fill = presentation.getSlotColor();
        float lineWidth = presentation.getLineWidth();
        boolean isDash = presentation.isDash();
        Stroke stroke;
        if (isDash) {
            stroke = new BasicStroke(lineWidth, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 1f,
                    new float[] {10f, 18f}, 0f);
        }
        else stroke = new BasicStroke(lineWidth);
        SerializableStrokeAdapter serializableStrokeAdapter = new SerializableStrokeAdapter(stroke);

        Type type;
        if (presentationView.isText()) type = Type.TEXT;
        else type = Type.IMAGE;

        Slot slot = new Slot(pos, Slot.slotDimension, fill, serializableStrokeAdapter, type);
        slideView.getSlide().addSlot(slot);
    }
}
