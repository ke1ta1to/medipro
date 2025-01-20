package medipro.level;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LevelView extends JPanel {

    public LevelView(LevelModel model, LevelController controller) {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel titleLabel = new JLabel("Select Level", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 4, 15, 15));
        String[] levels = { "Level 1", "Level 2", "Level 3", "Level 4", "Level 5", "Level 6", "Level 7", "Level 8" };

        for (String level : levels) {
            JButton button = new JButton(level);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.setActionCommand(level);
            button.addActionListener(controller);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        JPanel exitPanel = new JPanel(new GridLayout(1, 1, 15, 30));
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 20));
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(controller);
        exitPanel.add(exitButton);
        add(exitPanel, BorderLayout.SOUTH);

    }
}
