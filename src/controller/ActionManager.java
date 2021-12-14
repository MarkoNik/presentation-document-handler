package controller;


public class ActionManager {
    private NewAction newAction;
    private DeleteAction deleteAction;
    private InfoAction infoAction;
    private ChangeAuthorAction changeAuthorAction;
    private ChangeThemeAction changeThemeAction;
    private CreateSlotAction createSlotAction;
    private DeleteSlotAction deleteSlotAction;
    private MoveSlotAction moveSlotAction;

    public ActionManager() {
        init();
    }

    private void init() {
        newAction = new NewAction();
        deleteAction = new DeleteAction();
        infoAction = new InfoAction();
        changeAuthorAction = new ChangeAuthorAction();
        changeThemeAction = new ChangeThemeAction();
        createSlotAction = new CreateSlotAction();
        deleteSlotAction = new DeleteSlotAction();
        moveSlotAction = new MoveSlotAction();
    }

    public NewAction getNewAction() {
        return newAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public ChangeAuthorAction getChangeAuthorAction() {
        return changeAuthorAction;
    }

    public ChangeThemeAction getChangeThemeAction() {
        return changeThemeAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public CreateSlotAction getCreateSlotAction() {
        return createSlotAction;
    }

    public DeleteSlotAction getDeleteSlotAction() {
        return deleteSlotAction;
    }

    public MoveSlotAction getMoveSlotAction() {
        return moveSlotAction;
    }
}
