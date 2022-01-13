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
    private SlideShowAction slideShowAction;
    private EditAction editAction;
    private ColorChooserAction colorChooserAction;
    private UndoAction undoAction;
    private RedoAction redoAction;
    private SavePresentationAction savePresentationAction;
    private OpenPresentationAction openPresentationAction;
    private SaveProjectAction saveProjectAction;
    private OpenProjectAction openProjectAction;
    private SaveWorkspaceAction saveWorkspaceAction;
    private OpenWorkspaceAction openWorkspaceAction;

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
        slideShowAction = new SlideShowAction();
        editAction = new EditAction();
        colorChooserAction = new ColorChooserAction();
        undoAction = new UndoAction();
        redoAction = new RedoAction();
        savePresentationAction = new SavePresentationAction();
        openPresentationAction = new OpenPresentationAction();
        saveProjectAction = new SaveProjectAction();
        openProjectAction = new OpenProjectAction();
        saveWorkspaceAction = new SaveWorkspaceAction();
        openWorkspaceAction = new OpenWorkspaceAction();
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

    public SlideShowAction getSlideShowAction() {
        return slideShowAction;
    }

    public EditAction getEditAction() {
        return editAction;
    }

    public ColorChooserAction getColorChooserAction() {
        return colorChooserAction;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public SavePresentationAction getSavePresentationAction() {
        return savePresentationAction;
    }

    public OpenPresentationAction getOpenPresentationAction() {
        return openPresentationAction;
    }

    public SaveProjectAction getSaveProjectAction() {
        return saveProjectAction;
    }

    public OpenProjectAction getOpenProjectAction() {
        return openProjectAction;
    }

    public SaveWorkspaceAction getSaveWorkspaceAction() {
        return saveWorkspaceAction;
    }

    public OpenWorkspaceAction getOpenWorkspaceAction() {
        return openWorkspaceAction;
    }
}
