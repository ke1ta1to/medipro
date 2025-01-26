package medipro.input;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextChangeListener implements DocumentListener {

    private final InputModel model;
    private final InputController controller;
    private final JTextArea textArea;

    public TextChangeListener(InputModel model, InputController controller, JTextArea textArea) {
        this.model = model;
        this.controller = controller;
        this.textArea = textArea;
    }

    public InputModel getModel() {
        return model;
    }

    public InputController getController() {
        return controller;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateText(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateText(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateText(e);
    }

    private void updateText(DocumentEvent e) {
        // https://stackoverflow.com/questions/15206586/getting-attempt-to-mutate-notification-exception
        SwingUtilities.invokeLater(() -> {
            model.setText(textArea.getText());
        });
    }

}
