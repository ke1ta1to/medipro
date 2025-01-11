package medipro.top;

import javax.swing.*;
import java.awt.*;

public class TopFrame {

    private final JPanel panel;

    public TopFrame(TopModel model, TopController controller) {
        panel = new JPanel(new BorderLayout(20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(90, 30, 30, 30));

        JLabel gameNameLabel = new JLabel("GameName", JLabel.CENTER);
        gameNameLabel.setFont(new Font("Arial", Font.BOLD, 36));
        panel.add(gameNameLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 15, 15, 15);

        String[] buttonLabels = { "New Game Start", "Level Select", "Setting" };
        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.setPreferredSize(new Dimension(200, 60));
            button.setActionCommand(buttonLabels[i]);
            button.addActionListener(controller);

            gbc.gridx = 0;
            gbc.gridy = i;
            buttonPanel.add(button, gbc);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }
}
