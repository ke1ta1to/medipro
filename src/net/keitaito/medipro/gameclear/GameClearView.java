package net.keitaito.medipro.gameclear;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.keitaito.medipro.utils.Fonts;
import net.keitaito.medipro.utils.Views;

public class GameClearView extends JPanel {
    public static final int WIDTH = 250;
    public static final int HEIGHT = 80;

    private final GameClearModel model;
    private final GameClearController controller;

    public GameClearView(GameClearModel model, GameClearController controller) {
        this.model = model;
        this.controller = controller;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        // タイトルパネル
        JLabel titleLabel = new JLabel("ステージクリア");
        titleLabel.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false); // 背景を透明にする
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);
    }

    public GameClearModel getModel() {
        return model;
    }

    public GameClearController getController() {
        return controller;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Views.paintBackground(g, WIDTH, HEIGHT);

    }
}
