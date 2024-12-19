package views.game;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controllers.StageController;
import models.StageModel;

public class CommandPanel extends JPanel {

    private final StageModel stageModel;
    private final StageController stageController;

    private final JTextArea textArea;
    private final JButton runButton;

    public CommandPanel(StageModel stageModel, StageController stageController) {
        this.stageModel = stageModel;
        this.stageController = stageController;

        setBackground(Color.WHITE);
        setBorder(BorderFactory.createTitledBorder("コマンド"));

        textArea = new JTextArea();
        // TODO: 仮のコマンドを設定
        textArea.setText(
                "1000 true false\n500 false false\n500 false true\n1000 false false\n500 false true\n0 false false");

        runButton = new JButton("実行");
        runButton.addActionListener(e -> {
            String command = textArea.getText();
            stageController.reset();
            stageModel.setCommand(command);
            stageController.start();
        });

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(runButton);

        setLayout(new BorderLayout());
        add(textArea);
        add(buttonPanel, BorderLayout.SOUTH);
    }

}
