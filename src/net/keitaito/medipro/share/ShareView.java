package net.keitaito.medipro.share;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.keitaito.medipro.utils.Fonts;
import net.keitaito.medipro.utils.Views;
import net.keitaito.mediproserver.Inputs;

public class ShareView extends JPanel {

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;

    private ShareModel model;
    private ShareController controller;

    public ShareView(ShareModel model, ShareController controller) {
        this.model = model;
        this.controller = controller;

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        JLabel titleLabel = new JLabel("みんなの回答");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
        add(titleLabel, BorderLayout.NORTH);

        JPanel inputsPanel = new JPanel();
        inputsPanel.setOpaque(false);
        BoxLayout inputsLayout = new BoxLayout(inputsPanel, BoxLayout.Y_AXIS);
        inputsPanel.setLayout(inputsLayout);
        List<Inputs> inputs = model.getInputs();
        for (Inputs input : inputs) {
            JPanel inputPanel = new JPanel();
            inputPanel.setOpaque(false);
            BorderLayout inputLayout = new BorderLayout();
            inputPanel.setLayout(inputLayout);

            JLabel nameLabel = new JLabel(input.getName());
            nameLabel.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
            nameLabel.setMinimumSize(new Dimension(150, nameLabel.getPreferredSize().height));
            nameLabel.setPreferredSize(new Dimension(150, nameLabel.getPreferredSize().height));
            inputPanel.add(nameLabel, BorderLayout.WEST);

            JLabel valueLabel = new JLabel("文字数: " + input.getInput_text().length());
            valueLabel.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
            inputPanel.add(valueLabel, BorderLayout.CENTER);

            JButton tryButton = new JButton("試す");
            tryButton.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
            tryButton.setActionCommand(input.getInput_text());
            tryButton.addActionListener(controller::handleClickTryButton);
            inputPanel.add(tryButton, BorderLayout.EAST);

            inputPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, inputPanel.getPreferredSize().height));
            inputPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

            inputsPanel.add(inputPanel);
        }
        JScrollPane inputsScrollPane = new JScrollPane(inputsPanel);
        inputsScrollPane.setOpaque(false);
        add(inputsScrollPane, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton closeButton = new JButton("閉じる");
        closeButton.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
        closeButton.addActionListener(controller::handleClickCloseButton);
        buttonsPanel.add(closeButton);

        add(buttonsPanel, BorderLayout.SOUTH);
    }

    public ShareModel getModel() {
        return model;
    }

    public ShareController getController() {
        return controller;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Views.paintBackground(g, WIDTH, HEIGHT);
    }

}
