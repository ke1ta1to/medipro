package medipro.commands;

import java.awt.event.KeyEvent;

import medipro.IKeyAction;

public class UnhookCommand extends Command {

    public static final String UNHOOK_REGEX = "^unhook$";

    public UnhookCommand() {
        super(UNHOOK_REGEX);
    }

    @Override
    public void execute(IKeyAction action, String rawText) throws InterruptedException {
        action.addKey(KeyEvent.VK_J);
        sleep(10);
        action.removeKey(KeyEvent.VK_J);
    }

}
