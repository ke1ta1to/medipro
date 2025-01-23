package medipro.commands;

import medipro.IKeyAction;

public abstract class Command {

    private final String regex;

    public Command(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public boolean matches(String input) {
        return input.matches(regex);
    }

    public abstract void execute(IKeyAction action, String rawText) throws InterruptedException;

}
