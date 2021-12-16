package state.presentation;

public class PresentationStateManager {

    private PresentationState presentationState;
    private SlideShowState slideShowState;
    private EditState editState;

    public PresentationStateManager() {
        slideShowState = new SlideShowState();
        editState = new EditState();
        presentationState = editState;
    }

    public void setSlideShowState() {
        presentationState = slideShowState;
    }

    public void setEditState() {
        presentationState = editState;
    }

    public PresentationState getPresentationState() {
        return presentationState;
    }
}
