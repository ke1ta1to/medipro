package medipro.input;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import medipro.subjects.InputTextSubject;

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
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            controller.submit(textArea.getText());
            controller.start();
        });
        add(submitButton, BorderLayout.SOUTH);

        InputTextSubject.addObserver(text -> textArea.setText(text));
    }

    public InputModel getModel() {
        return model;
    }

    public InputController getController() {
        return controller;
    }

}
