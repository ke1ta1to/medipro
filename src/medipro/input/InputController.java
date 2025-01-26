package medipro.input;

import java.beans.PropertyChangeEvent;

import medipro.App;
import medipro.IKeyAction;
import medipro.World;
import medipro.commands.Command;
import medipro.commands.CommandStore;

public class InputController {

    private final InputModel model;

    public InputController(InputModel inputModel) {
        this.model = inputModel;

        App.getStageModel().addPropertyChangeListener("world", this::handleChangeWorld);
    }

    private void handleChangeWorld(PropertyChangeEvent evt) {
        World world = (World) evt.getNewValue();
        model.setText(world.getExampleCommand());
    }

    public InputModel getModel() {
        return model;
    }

    public void submit(String text) {
        App.getStageModel().getEntity().reset();
        model.setText(text);
    }

    public void start() {
        IKeyAction keyAction = App.getStageModel();
        CommandStore commandStore = App.getCommandStore();
        Thread thread = new Thread(() -> {
            try {
                String[] lines = model.getText().split("\n");
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
