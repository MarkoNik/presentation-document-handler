package model.error;

public class NodeNotSelectedError extends UserError {
    public NodeNotSelectedError() {
        super("Select something in the tree first");
    }
}
