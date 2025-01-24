package medipro.commands;

import medipro.IKeyAction;

public class LeftCommand extends Command {

    public LeftCommand() {
        super("^left$");
    }

    @Override
    public void execute(IKeyAction action, String rawText) {
        action.removeKey("d");
        action.addKey("a");
    }

}
