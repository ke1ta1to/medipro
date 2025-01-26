package medipro.commands;

import java.awt.event.KeyEvent;

import medipro.IKeyAction;

public class JumpCommand extends Command {

    public JumpCommand() {
        super("^jump$");
    }

    @Override
    public void execute(IKeyAction action, String rawText) throws InterruptedException {
        action.addKey(KeyEvent.VK_SPACE);
        sleep(10);
        action.removeKey(KeyEvent.VK_SPACE);
    }

}
