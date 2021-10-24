package Controller;

public class ActionManager {
    private NewAction newAction;
    private InfoAction infoAction;

    public ActionManager() {
        init();
    }

    private void init() {
        newAction = new NewAction();
        infoAction = new InfoAction();
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
}
