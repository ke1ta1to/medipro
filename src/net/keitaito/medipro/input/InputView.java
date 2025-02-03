package net.keitaito.medipro.input;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.keitaito.medipro.utils.Fonts;

public class InputView extends JPanel {

    private final InputModel model;
    private final InputController controller;

    private final JTextArea textArea;

    private final JButton helpButton;

    public InputView(InputModel model, InputController controller) {
        this.model = model;
        this.controller = controller;

        setPreferredSize(new Dimension(250, 0));

        BorderLayout layout = new BorderLayout();
        layout.setVgap(10);
        setLayout(layout);

        textArea = new JTextArea();
        textArea.setFont(Fonts.MPLUS1CODE_FONT.deriveFont(Font.PLAIN, 16));
        textArea.getDocument().addDocumentListener(controller.getTextChangeListener(textArea));
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);

        helpButton = new JButton("？");
        helpButton.setFont(Fonts.STICK_FONT.deriveFont(Font.PLAIN, 24));
        helpButton.addActionListener(controller::handleHelp);

        JButton submitButton = new JButton("実行");
        submitButton.setFont(Fonts.STICK_FONT.deriveFont(Font.PLAIN, 24));
        submitButton.addActionListener(controller::handleSubmit);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(helpButton, BorderLayout.WEST);
        buttonPanel.add(submitButton, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        model.addPropertyChangeListener("text", this::updateText);
    }

    public InputModel getModel() {
        return model;
    }

    public InputController getController() {
        return controller;
    }

    private void updateText(PropertyChangeEvent evt) {
        String newText = (String) evt.getNewValue();
        if (!textArea.getText().equals(newText)) {
            textArea.setText((String) evt.getNewValue());
        }
    }

}
