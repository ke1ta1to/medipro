package medipro.input;

import medipro.App;
import medipro.IKeyAction;
import medipro.commands.Command;
import medipro.commands.CommandStore;

public class InputController {

    private final InputModel inputModel;

    public InputController(InputModel inputModel) {
        this.inputModel = inputModel;

        App.getWorldSubject().addObserver((world) -> {
            App.getInputTextSubject().setText(world.getExampleCommand());
        });
    }

    public InputModel getModel() {
        return inputModel;
    }

    public void submit(String text) {
        App.getStageModel("submit").getEntity().reset();
        inputModel.setText(text);
    }

    public void start() {
        System.out.println(inputModel.getText());
        IKeyAction keyAction = App.getStageModel("init");
        CommandStore commandStore = App.getCommandStore();
        Thread thread = new Thread(() -> {
            try {
                String[] lines = inputModel.getText().split("\n");
                for (String line : lines) {
                    Command command = commandStore.getCommand(line);
                    if (command != null) {
                        command.execute(keyAction, line);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

}
