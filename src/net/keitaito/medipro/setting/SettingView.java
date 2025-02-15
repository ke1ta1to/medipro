package net.keitaito.medipro.setting;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.keitaito.medipro.utils.Fonts;

public class SettingView extends JPanel {

    public SettingView(SettingModel model, SettingController controller) {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel titleLabel = new JLabel("Setting", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        add(titleLabel, BorderLayout.NORTH);
        // TODO: 設定画面の詳細の作成
        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 10, 10));

        JLabel saveLabel = new JLabel("セーブ機能リセット", JLabel.CENTER);
        saveLabel.setFont(Fonts.STICK_FONT.deriveFont(40f));
        centerPanel.add(saveLabel);

        JButton destroySaveButton = new JButton("セーブ機能を破壊する");
        destroySaveButton.setFont(Fonts.STICK_FONT.deriveFont(40f));
        destroySaveButton.setActionCommand("destroy");
        destroySaveButton.addActionListener(controller::handleClickDestroySave);
        centerPanel.add(destroySaveButton);

        add(centerPanel, BorderLayout.CENTER);

        JPanel exitPanel = new JPanel(new GridLayout(1, 1, 15, 30));
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(Fonts.STICK_FONT.deriveFont(40f));
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(controller::handleClickExit);
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
