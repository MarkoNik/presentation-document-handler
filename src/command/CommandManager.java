package command;

import view.MainFrame;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private List<ICommand> commandStack = new ArrayList<>();
    private int currentCommand = 0;

    public void addCommand(ICommand command) {

        while(currentCommand < commandStack.size()) {
            commandStack.remove(currentCommand);
        }
        commandStack.add(command);
        doCommand();
    }

    public void doCommand() {

        if (currentCommand < commandStack.size()) {
            commandStack.get(currentCommand++).doCommand();
            MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
        }

        if (currentCommand == commandStack.size()) {
            MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
        }
    }

    public void undoCommand() {

        if (currentCommand > 0) {
            MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
            commandStack.get(--currentCommand).undoCommand();
        }

        if (currentCommand == 0) {
            MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
        }
    }
}
