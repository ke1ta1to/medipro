package net.keitaito.medipro.achievement;

import javax.swing.JPanel;

import net.keitaito.medipro.utils.Fonts;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

public class AchievementView extends JPanel {

    public AchievementView(AchievementModel model, AchievementController controller) {
        model.checkHelloWorld();
        model.checkAllClear();
        model.checkNotUseJump();
        model.checkCodeMax8();

        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel titleLabel = new JLabel("Achievement", JLabel.CENTER);
        titleLabel.setFont(Fonts.STICK_FONT.deriveFont(40f));
        add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(2, 2));

        JPanel firstAchievement = AChievement("Clear", "Hello,World!", model.isHelloWorld());
        centerPanel.add(firstAchievement);
        JPanel secondAchievement = AChievement("Clear", "Birth of a ledgend!", model.isAllClear());
        centerPanel.add(secondAchievement);
        JPanel thirdAchievement = AChievement("Clear", "You forgot jump command...", model.isNotUseJump());
        centerPanel.add(thirdAchievement);
        JPanel fourthAchievement = AChievement("Clear", "You're master of Risapuro", model.isCodeMax8());
        centerPanel.add(fourthAchievement);

        add(centerPanel, BorderLayout.CENTER);
        JPanel exitPanel = new JPanel(new GridLayout(1, 1, 15, 30));
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(Fonts.STICK_FONT.deriveFont(20f));
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(controller);
        exitPanel.add(exitButton);
        add(exitPanel, BorderLayout.SOUTH);
    }

    private JPanel AChievement(String name, String description, boolean isSatistactory) {
        JPanel panel = new JPanel(new BorderLayout());
        if (isSatistactory) {
            JLabel imageLabel = new JLabel(name);
            imageLabel.setFont(Fonts.STICK_FONT.deriveFont(20f));
            panel.add(imageLabel, BorderLayout.CENTER);
        }
        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setFont(Fonts.STICK_FONT.deriveFont(20f));
        panel.add(descriptionLabel, BorderLayout.SOUTH);
        return panel;
    }

}
