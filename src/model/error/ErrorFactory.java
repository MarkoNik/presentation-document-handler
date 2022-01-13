package model.error;

public class ErrorFactory {

    public static UserError generate(ERROR error) {
        return switch (error) {
            case ADD_CHILD_TO_SLIDE -> new AddChildToSlideError();
            case BLANK_NAME -> new BlankNameError();
            case DELETE_WORKSPACE -> new DeleteWorkspaceError();
            case NODE_NOT_SELECTED -> new NodeNotSelectedError();
            case PRESENTATION_NOT_SELECTED -> new PresentationNotSelectedError();
            case PROJECT_NOT_SELECTED -> new ProjectNotSelectedError();
            case WORKSPACE_NOT_SELECTED -> new WorkspaceNotSelectedError();
            case WRONG_PATH -> new WrongPathError();
        };
    }

}
