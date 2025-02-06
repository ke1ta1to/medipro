package net.keitaito.medipro.gameover;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.keitaito.medipro.utils.Fonts;
import net.keitaito.medipro.utils.Views;

public class GameOverView extends JPanel {
    public static final int WIDTH = 250;
    public static final int HEIGHT = 80;

    private final GameOverModel model;
    private final GameOverController controller;

    public GameOverView(GameOverModel model, GameOverController controller) {
        this.model = model;
        this.controller = controller;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        // タイトルパネル
        JLabel titleLabel = new JLabel("ゲームオーバー");
        titleLabel.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false); // 背景を透明にする
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);
    }

    public GameOverModel getModel() {
        return model;
    }

    public GameOverController getController() {
        return controller;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // TODO: デザインは好きに変えてくれ

        // 背景を描画
        Views.paintBackground(g, WIDTH, HEIGHT);
    }
}
