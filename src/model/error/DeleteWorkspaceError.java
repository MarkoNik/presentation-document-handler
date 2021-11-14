package model.error;

public class DeleteWorkspaceError extends UserError {
    public DeleteWorkspaceError() {
        super("Workspace can't be deleted");
    }
}
