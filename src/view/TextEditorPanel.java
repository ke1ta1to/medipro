package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.EditorModel;

public class TextEditorPanel extends JPanel implements ActionListener {
    private JTextArea textArea;
    private JButton RunButton;

    public TextEditorPanel() {
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        RunButton = new JButton("RUN");
        RunButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(RunButton);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == RunButton) {
            EditorModel logic = new EditorModel();
            logic.showtext(textArea.getText());
        }
    }

}
