package view.workspace.panels;

import model.workspace.Slide;
import view.workspace.SlideView;

public interface PresentationPanel {
    void addSlide(SlideView slideView);
    void addNavSlide(SlideView slideView);
    void removeSlide(Slide slide);
    void clearSlides();
}
