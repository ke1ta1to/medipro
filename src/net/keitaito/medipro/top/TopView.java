package net.keitaito.medipro.top;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.keitaito.medipro.components.TitleButton;
import net.keitaito.medipro.utils.Fonts;

public class TopView extends JPanel {

    public TopView(TopModel model, TopController controller) {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(90, 30, 30, 30));

        JLabel gameNameLabel = new JLabel("りさプロ！", JLabel.CENTER);
        gameNameLabel.setFont(Fonts.STICK_FONT.deriveFont(Font.PLAIN, 60));
        add(gameNameLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 15, 15, 15);

        String[] buttonLabels = { "New Game Start", "Level Select", "Setting", "How to Play" };
        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new TitleButton(buttonLabels[i]);
            button.setPreferredSize(new Dimension(200, 60));
            button.setActionCommand(buttonLabels[i]);
            button.addActionListener(controller);

            gbc.gridx = 0;
            gbc.gridy = i;
            buttonPanel.add(button, gbc);
        }

        add(buttonPanel, BorderLayout.CENTER);

    }

}
