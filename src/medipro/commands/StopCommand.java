package medipro.commands;

import medipro.IKeyAction;

public class StopCommand extends Command {

    public StopCommand() {
        super("^stop$");
    }

    @Override
    public void execute(IKeyAction action, String rawText) {
        action.clearKeys();
    }

}
