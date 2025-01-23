package medipro.input;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import medipro.App;
import medipro.utils.Fonts;

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
        textArea.setFont(Fonts.MPLUS1CODE_FONT.deriveFont(Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);

        JButton submitButton = new JButton("実行");
        submitButton.setFont(Fonts.STICK_FONT.deriveFont(Font.PLAIN, 24));
        submitButton.addActionListener(e -> {
            controller.submit(textArea.getText());
            controller.start();
        });
        add(submitButton, BorderLayout.SOUTH);

        App.getInputTextSubject().addObserver(text -> textArea.setText(text));
    }

    public InputModel getModel() {
        return model;
    }

    public InputController getController() {
        return controller;
    }

}
