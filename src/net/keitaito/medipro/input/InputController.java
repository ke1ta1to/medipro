package net.keitaito.medipro.input;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JTextArea;

import net.keitaito.medipro.App;
import net.keitaito.medipro.IKeyAction;
import net.keitaito.medipro.commands.Command;
import net.keitaito.medipro.commands.CommandStore;
import net.keitaito.medipro.helpdialog.HelpDialogModel;

public class InputController {

    private final InputModel model;

    public InputController(InputModel inputModel) {
        this.model = inputModel;
        App.getStageModel().addPropertyChangeListener("world", this::handleChangeWorld);
    }

    private void handleChangeWorld(PropertyChangeEvent evt) {
        System.out.println("handleChangeWorld");
        model.loadInputText();
    }

    public InputModel getModel() {
        return model;
    }

    public TextChangeListener getTextChangeListener(JTextArea textArea) {
        return new TextChangeListener(model, this, textArea);
    }

    public void handleSubmit(ActionEvent event) {
        App.getGameOverModel().setOpen(false);
        App.getGameClearModel().setOpen(false);
        App.getStageModel().getEntity().reset();
        start();
    }

    public void handleHelp(ActionEvent event) {
        HelpDialogModel helpDialogModel = App.getHelpDialogModel();
        helpDialogModel.setOpen(!helpDialogModel.isOpen());
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
