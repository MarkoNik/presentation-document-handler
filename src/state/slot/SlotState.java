package state.slot;

import view.workspace.SlideView;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class SlotState {
    public void mouseClick(MouseEvent e, SlideView slide) { }
    public void mouseDrag() { }
    public void mouseRelease() { }
}
