package medipro.app;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class StartPanel extends JPanel {

    public StartPanel(AppController appController) {
        setLayout(new BorderLayout());

        JLabel gameNameLabel = new JLabel("GameName", JLabel.CENTER);

        GridLayout gridLayout = new GridLayout(3, 1, 10, 10);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(gridLayout);

        JButton startButton = new JButton("New Game Start");
        startButton.setActionCommand("New Game Start");
        startButton.addActionListener(appController);

        JButton levelButton = new JButton("Level Select");
        levelButton.setActionCommand("Level Select");
        levelButton.addActionListener(appController);

        JButton settingButton = new JButton("Setting");
        settingButton.setActionCommand("Setting");
        settingButton.addActionListener(appController);

        buttonPanel.add(startButton);
        buttonPanel.add(levelButton);
        buttonPanel.add(settingButton);

        add(gameNameLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
}
