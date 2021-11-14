package model.error;

public class PresentationNotSelectedError extends UserError {
    public PresentationNotSelectedError() {
        super("Select presentation first");
    }
}
