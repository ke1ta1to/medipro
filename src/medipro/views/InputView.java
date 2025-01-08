package medipro.views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import medipro.controllers.InputController;
import medipro.models.InputModel;

public class InputView extends JPanel {

    private final InputModel model;
    private final InputController controller;

    public InputView(InputModel model, InputController controller) {
        this.model = model;
        this.controller = controller;

        setPreferredSize(new Dimension(250, 0));

        BorderLayout layout = new BorderLayout();
        layout.setVgap(10);
        setLayout(layout);

        JTextArea textArea = new JTextArea();
        textArea.setFont(textArea.getFont().deriveFont(16f));
        add(textArea, BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
        add(submitButton, BorderLayout.SOUTH);
    }

    public InputModel getModel() {
        return model;
    }

    public InputController getController() {
        return controller;
    }

}
