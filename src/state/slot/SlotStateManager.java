package state.slot;

public class SlotStateManager {

    private SlotState state;
    private CreateState createState;
    private DeleteState deleteState;
    private MoveState moveState;

    public SlotStateManager() {
        createState = new CreateState();
        deleteState = new DeleteState();
        moveState = new MoveState();
        state = createState;
    }

    public void setAddState() {
        state = createState;
    }

    public void setDeleteState() {
        state = deleteState;
    }

    public void setMoveState() {
        state = moveState;
    }

}
