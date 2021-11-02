package Controller;


public class ActionManager {
    private NewAction newAction;
    private InfoAction infoAction;
    private ChangeAuthorAction changeAuthorAction;
    private ChangeThemeAction changeThemeAction;

    public ActionManager() {
        init();
    }

    private void init() {
        newAction = new NewAction();
        infoAction = new InfoAction();
        changeAuthorAction = new ChangeAuthorAction();
        changeThemeAction = new ChangeThemeAction();
    }

    public NewAction getNewAction() {
        return newAction;
    }

    public void setNewAction(NewAction newAction) {
        this.newAction = newAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public void setInfoAction(InfoAction infoAction) {
        this.infoAction = infoAction;
    }

    public ChangeAuthorAction getChangeAuthorAction() {
        return changeAuthorAction;
    }

    public void setChangeAuthorAction(ChangeAuthorAction changeAuthorAction) {
        this.changeAuthorAction = changeAuthorAction;
    }

    public ChangeThemeAction getChangeThemeAction() {
        return changeThemeAction;
    }

    public void setChangeThemeAction(ChangeThemeAction changeThemeAction) {
        this.changeThemeAction = changeThemeAction;
    }
}
