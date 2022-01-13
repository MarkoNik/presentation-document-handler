package model.error;

public class WorkspaceNotSelectedError extends UserError {
    public WorkspaceNotSelectedError() {
        super("Select workspace first");
    }
}
