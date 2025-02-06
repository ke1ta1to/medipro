package net.keitaito.medipro.gameclear;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.keitaito.medipro.utils.Fonts;
import net.keitaito.medipro.utils.Views;

public class GameClearView extends JPanel {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

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

        // シェア登録パネル
        JPanel sharePanel = new JPanel();
        sharePanel.setOpaque(false); // 背景を透明にする
        BorderLayout shareLayout = new BorderLayout();
        sharePanel.setLayout(shareLayout);

        JPanel textPanel = new JPanel();
        FlowLayout textLayout = new FlowLayout();
        textPanel.setLayout(textLayout);
        textPanel.setOpaque(false); // 背景を透明にする
        JLabel textLabel = new JLabel("登録名: ");
        textLabel.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
        textPanel.add(textLabel);

        JTextField nameField = new JTextField(10);
        nameField.setFont(Fonts.STICK_FONT.deriveFont(20.0f));

        textPanel.add(nameField);

        JPanel buttonPanel = new JPanel();
        FlowLayout buttonLayout = new FlowLayout();
        buttonPanel.setLayout(buttonLayout);
        buttonPanel.setOpaque(false); // 背景を透明にする
        JButton shareButton = new JButton("登録");
        shareButton.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
        shareButton.addActionListener(e -> controller.handleClickRegisterButton(nameField.getText()));

        buttonPanel.add(shareButton);

        sharePanel.add(textPanel, BorderLayout.WEST);

        sharePanel.add(buttonPanel, BorderLayout.EAST);

        add(sharePanel, BorderLayout.CENTER);

        model.addPropertyChangeListener("registered", (e) -> {
            if (model.isRegistered()) {
                shareButton.setEnabled(false);
                shareButton.setText("登録済み");
            }
        });
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
