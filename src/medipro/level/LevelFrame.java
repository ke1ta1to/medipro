package medipro.level;

import javax.swing.*;
import java.awt.*;

public class LevelFrame {
    private final JPanel panel;

    public LevelFrame(LevelModel model, LevelController controller) {
        panel = new JPanel(new BorderLayout(20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel titleLabel = new JLabel("Select Level", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 4, 15, 15));
        String[] levels = { "Level 1", "Level 2", "Level 3", "Level 4", "Level 5", "Level 6", "Level 7", "Level 8" };

        for (String level : levels) {
            JButton button = new JButton(level);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.setActionCommand(level);
            button.addActionListener(controller);
            buttonPanel.add(button);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }
}
