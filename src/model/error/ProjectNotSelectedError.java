package model.error;

public class ProjectNotSelectedError extends UserError {
    public ProjectNotSelectedError() {
        super("Select project first");
    }
}
