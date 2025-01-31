package net.keitaito.medipro.input_command_menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InputCommandMenuView extends JPanel {

    public static final int WIDTH = 100;
    public static final int HEIGHT = 300;

    private final InputCommandMenuModel model;
    private final InputCommandMenuController controller;

    JPanel commandPanel;
    private CardLayout commandPanelLayout;

    public InputCommandMenuView(InputCommandMenuModel model, InputCommandMenuController controller) {
        this.model = model;
        this.controller = controller;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        JLabel label = new JLabel("コマンド一覧");
        titlePanel.add(label);
        add(titlePanel, BorderLayout.NORTH);

        commandPanelLayout = new CardLayout();
        commandPanel = new JPanel();
        commandPanel.setLayout(commandPanelLayout);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        java.util.List<String> commandList = java.util.Arrays.asList("right", "left", "stop", "jump", "wait", "hook",
                "unhook");
        for (String command : commandList) {
            JButton commandButton = new JButton(command);
            // commandButton.addActionListener(e -> controller.handleCommand(command));
            commandButton.addActionListener(e -> controller.handleCommand(command));
            mainPanel.add(commandButton);
        }
        JPanel leftLabel = createCommandDetailPanel("left", "左に動き続ける");
        JPanel rightLabel = createCommandDetailPanel("right", "右に動き続ける");
        JPanel stopLabel = createCommandDetailPanel("stop", "停止する");
        JPanel jumpLabel = createCommandDetailPanel("jump", "ジャンプする");
        JPanel waitLabel = createCommandDetailPanel("wait", "n秒間それ以下のコマンドの実行を止める");
        JPanel hookLabel = createCommandDetailPanel("hook", "left/rightの方向にフックを出す");
        JPanel unhookLabel = createCommandDetailPanel("unhook", "フックをひっこめる");
        commandPanel.add(mainPanel, "mainPanel");
        commandPanel.add(rightLabel, "right");
        commandPanel.add(leftLabel, "left");
        commandPanel.add(stopLabel, "stop");
        commandPanel.add(jumpLabel, "jump");
        commandPanel.add(waitLabel, "wait");
        commandPanel.add(hookLabel, "hook");
        commandPanel.add(unhookLabel, "unhook");
        model.addPropertyChangeListener("page", this::handleChangePageName);

        add(commandPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        GridLayout bottomPanelLayout = new GridLayout(1, 2);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanel.setPreferredSize(new Dimension(350, 50));
        JButton backButton = new JButton("戻る");
        backButton.addActionListener(controller::handleClose);
        bottomPanel.add(backButton);

        JPanel bottomWrapperPanel = new JPanel();
        bottomWrapperPanel.setLayout(new FlowLayout());

        bottomWrapperPanel.add(bottomPanel);
        add(bottomWrapperPanel, BorderLayout.SOUTH);
    }

    private JPanel createCommandDetailPanel(String command, String detail) {
        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new BorderLayout());

        JLabel commandLabel = new JLabel(command);

        JLabel detailLabel = new JLabel(detail);
        detailPanel.add(commandLabel, BorderLayout.NORTH);
        detailPanel.add(detailLabel, BorderLayout.CENTER);

        JButton backButton = new JButton("戻る");
        backButton.addActionListener(e -> controller.handleCommand("mainPanel"));
        detailPanel.add(backButton, BorderLayout.SOUTH);
        model.addPropertyChangeListener("page", this::handleChangePageName);
        return detailPanel;
    }

    private void handleChangePageName(PropertyChangeEvent evt) {
        CardLayout layout = commandPanelLayout;
        layout.show(commandPanel, (String) evt.getNewValue());
    }

}
