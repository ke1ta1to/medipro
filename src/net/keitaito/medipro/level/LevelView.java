package net.keitaito.medipro.level;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.keitaito.medipro.App;
import net.keitaito.medipro.utils.Fonts;
import net.keitaito.medipro.worlds.World;

public class LevelView extends JPanel {

    public LevelView(LevelModel model, LevelController controller) {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel titleLabel = new JLabel("Select Level", JLabel.CENTER);
        titleLabel.setFont(Fonts.STICK_FONT.deriveFont(40f));
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 4, 15, 15));
        World[] levels = {
                App.worldLevel1,
                App.worldLevel2,
                App.worldLevel3,
                App.worldLevel4,
                App.worldLevel5,
                App.worldLevel6,
                App.worldLevel7,
                App.worldLevel8
        };

        for (int i = 0; i < levels.length; i++) {
            World world = levels[i];
            JButton button = new JButton();
            button.setActionCommand(String.valueOf(i + 1));
            button.addActionListener(controller);
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Draw the world image
                    int imageWidth = world.getThumbnail().getWidth(this);
                    int imageHeight = world.getThumbnail().getHeight(this);
                    int labelWidth = this.getWidth();
                    int labelHeight = this.getHeight();
                    double scale = Math.max((double) labelWidth / imageWidth, (double) labelHeight / imageHeight);
                    int width = (int) (imageWidth * scale);
                    int height = (int) (imageHeight * scale);
                    int x = (labelWidth - width) / 2;
                    int y = (labelHeight - height) / 2;
                    g.drawImage(world.getThumbnail(), x, y, width, height, this);
                }
            };
            panel.setOpaque(false);
            panel.setLayout(new BorderLayout());

            JLabel textLabel = new JLabel();
            textLabel.setText(world.getMetadata().getTitle());
            textLabel.setVerticalAlignment(JLabel.TOP);
            textLabel.setFont(Fonts.STICK_FONT.deriveFont(30f));
            textLabel.setForeground(Fonts.FOREGROUND_COLOR);
            panel.add(textLabel, BorderLayout.CENTER);
            textLabel.setBackground(Color.WHITE);

            button.add(panel);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        JPanel exitPanel = new JPanel(new GridLayout(1, 1, 15, 30));
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(Fonts.STICK_FONT.deriveFont(40f));
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(controller);
        exitPanel.add(exitButton);
        add(exitPanel, BorderLayout.SOUTH);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon icon = new ImageIcon(
                getClass().getClassLoader().getResource("net/keitaito/medipro/images/background.png"));
        g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
}
