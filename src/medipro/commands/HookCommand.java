package medipro.commands;

import medipro.IKeyAction;

public class HookCommand extends Command {

    public static final String HOOK_REGEX = "^hook (right|left)$";
    public static final String HOOK_RIGHT_REGEX = "^hook right$";
    public static final String HOOK_LEFT_REGEX = "^hook left$";

    public HookCommand() {
        super(HOOK_REGEX);
    }

    @Override
    public void execute(IKeyAction action, String rawText) throws InterruptedException {
        if (rawText.matches(HOOK_RIGHT_REGEX)) {
            action.addKey(75);
            sleep(10);
            action.removeKey(75);
        } else if (rawText.matches(HOOK_LEFT_REGEX)) {
            action.addKey(72);
            sleep(10);
            action.removeKey(72);
        }
    }

}
