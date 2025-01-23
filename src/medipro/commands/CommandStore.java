package medipro.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandStore {

    private final List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public Command getCommand(String input) {
        for (Command command : commands) {
            if (command.matches(input)) {
                return command;
            }
        }
        return null;
    }

    public List<Command> getCommands() {
        return commands;
    }
}
