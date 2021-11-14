package model.error;

public class WrongPathError extends UserError {
    public WrongPathError() {
        super("Themes have to be inserted from the 'themes' folder");
    }
}
