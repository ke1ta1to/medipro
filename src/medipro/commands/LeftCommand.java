package medipro.commands;

import java.awt.event.KeyEvent;

import medipro.IKeyAction;

public class LeftCommand extends Command {

    public LeftCommand() {
        super("^left$");
    }

    @Override
    public void execute(IKeyAction action, String rawText) {
        action.removeKey(KeyEvent.VK_D);
        action.addKey(KeyEvent.VK_A);
    }

}
