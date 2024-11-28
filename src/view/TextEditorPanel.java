package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.EditorModel;

public class TextEditorPanel extends JPanel implements ActionListener {
    private JTextArea textArea;
    private JButton runButton;

    public TextEditorPanel() {
        textArea = new JTextArea();
        runButton = new JButton("RUN");
        runButton.addActionListener(this);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(runButton);

        JScrollPane scrollPane = new JScrollPane(textArea);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == runButton) {
            EditorModel logic = new EditorModel();
            logic.showtext(textArea.getText());
        }
    }

}
