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
                "move left\nwait 50\nmove right\nwait 100\nstop\nwait 50");

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
