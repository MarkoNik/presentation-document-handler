package model.error;

public class AddChildToSlideError extends UserError {
    public AddChildToSlideError() {
        super("Slide can't have children");
    }
}
