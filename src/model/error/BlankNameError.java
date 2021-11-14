package model.error;

public class BlankNameError extends UserError {
    public BlankNameError() {
        super("Name can't be blank");
    }
}
