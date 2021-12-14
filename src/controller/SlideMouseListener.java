package controller;

import view.workspace.SlideView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SlideMouseListener implements MouseListener {

    private SlideView slideView;

    public SlideMouseListener(SlideView slideView) {
        this.slideView = slideView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        slideView.clicked(e.getPoint());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
