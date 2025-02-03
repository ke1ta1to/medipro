package net.keitaito.medipro.helpdialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.keitaito.medipro.utils.Fonts;
import net.keitaito.medipro.utils.Views;

public class HelpDialogView extends JPanel {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 580;

    private final HelpDialogModel model;
    private final HelpDialogController controller;

    public HelpDialogView(HelpDialogModel model, HelpDialogController controller) {
        this.model = model;
        this.controller = controller;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // setOpaque(false); // 不透明にする。必要なら。

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        // タイトルパネル
        JLabel titleLabel = new JLabel("コマンド情報");
        titleLabel.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false); // 背景を透明にする
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // ボタンパネル
        JButton closeButton = new JButton("閉じる");
        closeButton.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
        closeButton.addActionListener(controller::handleClickCloseButton);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setOpaque(false); // 背景を透明にする
        buttonPanel.add(closeButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public HelpDialogModel getModel() {
        return model;
    }

    public HelpDialogController getController() {
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
