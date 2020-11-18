package command;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class CommandRegistry {

    private ObservableList<Command> commandStack = FXCollections
            .observableArrayList();

    private List<Command> undoneStack = new ArrayList<>();

    public void executeCommand(Command command) {
        command.execute();
        commandStack.add(command);
    }

    public void redo() {

        if (!undoneStack.isEmpty()) {
            Command command = undoneStack.remove(undoneStack.size() - 1);
            command.redo();
            commandStack.add(command);
        }
    }

    public void undo() {
        if (!commandStack.isEmpty()) {
            Command command = commandStack.remove(commandStack.size() - 1);
            command.undo();
            undoneStack.add(command);
        }
    }

    public ObservableList<Command> getCommandStack() {
        return commandStack;
    }
}
