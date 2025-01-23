package medipro.commands;

import medipro.IKeyAction;

public class JumpCommand extends Command {

    public JumpCommand() {
        super("^jump$");
    }

    @Override
    public void execute(IKeyAction action, String rawText) throws InterruptedException {
        action.addKey(" ");
        Thread.sleep(10);
        action.removeKey(" ");
    }

}
