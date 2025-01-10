package medipro.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class StartPanel extends JPanel {

    public StartPanel(AppController appController) {
        setBorder(new EmptyBorder(90, 30, 30, 30));
        setLayout(new BorderLayout(20, 20));
        
        JLabel gameNameLabel = new JLabel("GameName", JLabel.CENTER);
        gameNameLabel.setFont(new Font("Arial", Font.BOLD, 36));
        add(gameNameLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 15, 15, 15);

        JButton startButton = new JButton("New Game Start");
        startButton.setFont(new Font("Arial", Font.PLAIN, 20));
        startButton.setPreferredSize(new Dimension(200, 60)); 
        startButton.setActionCommand("New Game Start");
        startButton.addActionListener(appController);
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(startButton, gbc);

        JButton levelButton = new JButton("Level Select");
        levelButton.setFont(new Font("Arial", Font.PLAIN, 20));
        levelButton.setPreferredSize(new Dimension(200, 60)); 
        levelButton.setActionCommand("Level Select");
        levelButton.addActionListener(appController);
        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanel.add(levelButton, gbc);

        JButton settingButton = new JButton("Setting");
        settingButton.setFont(new Font("Arial", Font.PLAIN, 20));
        settingButton.setPreferredSize(new Dimension(200, 60));
        settingButton.setActionCommand("Setting");
        settingButton.addActionListener(appController);
        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonPanel.add(settingButton, gbc);

        add(buttonPanel, BorderLayout.CENTER);
    }
}
