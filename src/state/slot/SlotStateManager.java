package state.slot;

public class SlotStateManager {

    private SlotState state;
    private CreateState createState;
    private DeleteState deleteState;
    private MoveState moveState;
    private SleepState sleepState;

    public SlotStateManager() {
        createState = new CreateState();
        deleteState = new DeleteState();
        moveState = new MoveState();
        sleepState = new SleepState();
        state = sleepState;
    }

    public void setCreateState() {
        state = createState;
    }

    public void setDeleteState() {
        state = deleteState;
    }

    public void setMoveState() {
        state = moveState;
    }

    public void setSleepState() { state = sleepState; }

    public SlotState getState() {
        return state;
    }
}
