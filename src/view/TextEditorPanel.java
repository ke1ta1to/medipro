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
    EditorModel editorModel;

    public TextEditorPanel(EditorModel editorModel) {
        this.editorModel = editorModel;

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        runButton = new JButton("RUN");
        runButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(runButton);

        JScrollPane scrollPanel = new JScrollPane(textArea);

        setLayout(new BorderLayout());
        add(scrollPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == runButton) {
            String text = textArea.getText();
            editorModel.compileText(text);
        }
    }
}
