package medipro.stage_menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StageMenuView extends JPanel {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    private final StageMenuModel model;
    private final StageMenuController controller;

    public StageMenuView(StageMenuModel model, StageMenuController controller) {
        this.model = model;
        this.controller = controller;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        JLabel label = new JLabel("メニュー");
        titlePanel.add(label);
        add(titlePanel, BorderLayout.NORTH);

        JPanel actionsPanel = new JPanel();
        BoxLayout actionsPanelLayout = new BoxLayout(actionsPanel, BoxLayout.Y_AXIS);
        actionsPanel.setLayout(actionsPanelLayout);
        actionsPanel.add(createButtonPanel("ステージ選択", "ステージ選択", (e) -> {
        }));
        actionsPanel.add(createButtonPanel("設定", "設定", (e) -> {
        }));
        JPanel actionsWrapperPanel = new JPanel();
        actionsWrapperPanel.setLayout(new FlowLayout());
        actionsWrapperPanel.add(actionsPanel);
        add(actionsWrapperPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        GridLayout bottomPanelLayout = new GridLayout(1, 2);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanel.setPreferredSize(new Dimension(350, 50));
        JButton backButton = new JButton("戻る");
        backButton.addActionListener((e) -> {
            controller.handleClose();
        });
        JButton exitButton = new JButton("終了");
        bottomPanel.add(backButton);
        bottomPanel.add(exitButton);
        JPanel bottomWrapperPanel = new JPanel();
        bottomWrapperPanel.setLayout(new FlowLayout());
        bottomWrapperPanel.add(bottomPanel);
        add(bottomWrapperPanel, BorderLayout.SOUTH);
    }

    public StageMenuModel getModel() {
        return model;
    }

    public StageMenuController getController() {
        return controller;
    }

    private JPanel createButtonPanel(String labelText, String buttonText, ActionListener actionListener) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(350, 50));
        JLabel label = new JLabel(labelText);
        panel.add(label, BorderLayout.WEST);
        JButton button = new JButton(buttonText);
        button.setPreferredSize(new Dimension(150, 50));
        button.addActionListener(actionListener);
        panel.add(button, BorderLayout.EAST);
        return panel;
    }

}
