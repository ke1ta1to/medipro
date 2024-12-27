package medipro.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CommandInputView extends JPanel {

    private final JTextArea textArea;
    private final JButton button;

    public CommandInputView() {
        textArea = new JTextArea();
        button = new JButton("実行");

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(200, 0));

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        add(textArea, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }

}
