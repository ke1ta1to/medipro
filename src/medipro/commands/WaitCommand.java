package medipro.commands;

import medipro.IKeyAction;

public class WaitCommand extends Command {

    private static final String WAIT_REGEX = "^wait \\d+(s|ms)$";
    // 単位がsの時の正規表現
    private static final String WAIT_S_REGEX = "^wait \\d+s$";
    // 単位がmsの時の正規表現
    private static final String WAIT_MS_REGEX = "^wait \\d+ms$";

    public WaitCommand() {
        super(WAIT_REGEX);
    }

    @Override
    public void execute(IKeyAction action, String rawText) throws InterruptedException {
        // WAIT_S_REGEXとWAIT_MS_REGEX
        if (rawText.matches(WAIT_S_REGEX)) {
            // 単位がsの時
            String[] split = rawText.split(" ");
            int time = Integer.parseInt(split[1].replace("s", ""));
            sleep(time * 1000);
        } else if (rawText.matches(WAIT_MS_REGEX)) {
            // 単位がmsの時
            String[] split = rawText.split(" ");
            int time = Integer.parseInt(split[1].replace("ms", ""));
            sleep(time);
        }
    }

}
