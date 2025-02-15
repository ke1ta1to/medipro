package net.keitaito.medipro.top;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopView extends JPanel {

    public TopView(TopModel model, TopController controller) {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel gameNameLabel = new JLabel();
        // center
        gameNameLabel.setHorizontalAlignment(JLabel.CENTER);

        ImageIcon titleIcon = new ImageIcon(
                getClass().getClassLoader().getResource("net/keitaito/medipro/images/title.png"));
        // サイズを調整
        titleIcon = new ImageIcon(titleIcon.getImage().getScaledInstance(600, 120, java.awt.Image.SCALE_SMOOTH));
        gameNameLabel.setIcon(titleIcon);
        add(gameNameLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 15, 0, 15); // 余白

        String[] buttonLabels = { "New Game Start", "Level Select", "Setting", "How to Play", "Achievement" };
        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton();
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            ImageIcon icon = new ImageIcon(
                    getClass().getClassLoader().getResource("net/keitaito/medipro/images/"
                            + buttonLabels[i].toLowerCase() + ".png"));
            // サイズを調整
            button.setIcon(new ImageIcon(icon.getImage().getScaledInstance(300, 60, java.awt.Image.SCALE_SMOOTH)));
            // button.setPreferredSize(new Dimension(200, 40));
            button.setActionCommand(buttonLabels[i]);
            button.addActionListener(controller);

            gbc.gridx = 0;
            gbc.gridy = i;
            buttonPanel.add(button, gbc);
        }

        add(buttonPanel, BorderLayout.CENTER);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon icon = new ImageIcon(
                getClass().getClassLoader().getResource("net/keitaito/medipro/images/background.png"));
        g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
    }

}
