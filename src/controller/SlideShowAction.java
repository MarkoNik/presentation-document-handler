package controller;

import view.MainFrame;
import view.workspace.PresentationView;

import java.awt.event.ActionEvent;

public class SlideShowAction extends AbstractRudokAction {

    public SlideShowAction() {
        putValue(SMALL_ICON, loadIcon("icons/slideShow.png"));
        putValue(NAME, "Slideshow");
        putValue(SHORT_DESCRIPTION, "Slideshow");
    }

    @Override
    public
    void actionPerformed(ActionEvent e) {
        ((PresentationView) MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedComponent())
                .startSlideShow();
    }
}