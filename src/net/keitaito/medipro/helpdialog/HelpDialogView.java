package net.keitaito.medipro.helpdialog;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

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
    private final CardLayout cardLayout;
    private final JPanel cardPanel;

    public HelpDialogView(HelpDialogModel model, HelpDialogController controller) {
        this.model = model;
        this.controller = controller;
        this.cardLayout = new CardLayout();
        this.cardPanel = new JPanel(cardLayout);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        // タイトルパネル
        JLabel titleLabel = new JLabel("コマンド情報");
        titleLabel.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false); // 背景を透明にする
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // カードパネル
        JPanel contentPanel = CreateContentsPanel();
        contentPanel.setOpaque(false); // 背景を透明にする
        cardPanel.add(contentPanel, "main");
        add(cardPanel, BorderLayout.CENTER);

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

    private JPanel CreateContentsPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        List<String> commands = Arrays.asList(
                "left : 右に動き続ける",
                "right : 左に動き続ける",
                "jump : ジャンプする",
                "wait",
                "stop : 左右の動きを止める",
                "hook",
                "unhook : フックを離す");
        panel.setLayout(new GridLayout(commands.size(), 1));
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT - 100));

        for (String command : commands) {
            if (command.equals("wait")) {
                JPanel explainPanel = new JPanel();
                explainPanel.setOpaque(false);
                JLabel commandLabel = new JLabel(command + " : 処理を停止する");
                commandLabel.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
                commandLabel.setHorizontalAlignment(JLabel.CENTER);
                explainPanel.add(commandLabel);
                JButton commandButton = new JButton("▼");
                commandButton.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
                commandButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JPanel newPanel = new JPanel();
                        newPanel.setOpaque(false);
                        newPanel.setLayout(new BorderLayout());
                        JLabel commandNameLabel = new JLabel(command);
                        commandNameLabel.setHorizontalAlignment(JLabel.CENTER);
                        commandNameLabel.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
                        newPanel.add(commandNameLabel, BorderLayout.NORTH);

                        JLabel descriptionLabel = new JLabel();
                        descriptionLabel.setOpaque(false);
                        descriptionLabel
                                .setText("<html><div style='text-align: left; line-height: 1.5; font-size: 14px;'>"
                                        + "<b>wait</b>は指定した時間だけ<br>"
                                        + "処理を停止するコマンドです<br>"
                                        + "<hr>"
                                        + "<b>wait n s:</b> n秒だけ処理を停止します<br>"
                                        + "例: <i>wait 1s</i> - 1秒間処理を停止<br>"
                                        + "<hr>"
                                        + "<b>wait n ms:</b> nミリ秒だけ処理を停止します<br>"
                                        + "例: <i>wait 500ms</i> - 500ミリ秒間処理を停止"
                                        + "</div></html>");
                        descriptionLabel.setFont(Fonts.STICK_FONT.deriveFont(16.0f));
                        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);
                        newPanel.add(descriptionLabel, BorderLayout.CENTER);

                        JButton backButton = new JButton("戻る");
                        backButton.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
                        backButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                cardLayout.show(cardPanel, "main");
                            }
                        });
                        newPanel.add(backButton, BorderLayout.SOUTH);

                        cardPanel.add(newPanel, command);
                        cardLayout.show(cardPanel, command);
                    }
                });
                explainPanel.add(commandButton);
                panel.add(explainPanel);
            } else if (command.equals("hook")) {
                JPanel explainPanel = new JPanel();
                explainPanel.setOpaque(false);
                JLabel commandLabel = new JLabel(command + " : フックを飛ばす");
                commandLabel.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
                commandLabel.setHorizontalAlignment(JLabel.CENTER);
                explainPanel.add(commandLabel);
                JButton commandButton = new JButton("▼");
                commandButton.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
                commandButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JPanel newPanel = new JPanel();
                        newPanel.setOpaque(false);
                        newPanel.setLayout(new BorderLayout());
                        JLabel commandNameLabel = new JLabel(command);
                        commandNameLabel.setHorizontalAlignment(JLabel.CENTER);
                        commandNameLabel.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
                        newPanel.add(commandNameLabel, BorderLayout.NORTH);

                        JLabel descriptionLabel = new JLabel();
                        descriptionLabel
                                .setText("<html><div style='text-align: left; line-height: 1.5; font-size: 14px;'>"
                                        + "<b>hook</b>は指定した方向に<br>"
                                        + "フックを飛ばすコマンドです。<br>"
                                        + "フックは壁に当たるまで飛び続けます。<br>"
                                        + "フックは壁に当たると、その位置に<br>"
                                        + "プレイヤーが移動します。<br>"
                                        + "<hr>"
                                        + "<b>hook left:</b> フックを左に飛ばす<br>"
                                        + "<hr>"
                                        + "<b>hook right:</b> フックを左に飛ばす<br>"
                                        + "</div></html>");
                        descriptionLabel.setFont(Fonts.STICK_FONT.deriveFont(16.0f));
                        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);
                        newPanel.add(descriptionLabel, BorderLayout.CENTER);

                        JButton backButton = new JButton("戻る");
                        backButton.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
                        backButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                cardLayout.show(cardPanel, "main");
                            }
                        });
                        newPanel.add(backButton, BorderLayout.SOUTH);

                        cardPanel.add(newPanel, command);
                        cardLayout.show(cardPanel, command);
                    }
                });
                explainPanel.add(commandButton);
                panel.add(explainPanel);
            } else {
                JLabel commandLabel = new JLabel(command);
                commandLabel.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
                commandLabel.setHorizontalAlignment(JLabel.CENTER);
                panel.add(commandLabel);
            }
        }

        return panel;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

}
