package net.keitaito.medipro.stagemenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.keitaito.medipro.App;
import net.keitaito.medipro.app.AppModel;
import net.keitaito.medipro.utils.Fonts;
import net.keitaito.medipro.utils.Views;

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
        titlePanel.setOpaque(false);
        JLabel label = new JLabel("メニュー");
        label.setFont(Fonts.STICK_FONT.deriveFont(20.0f));
        titlePanel.add(label);
        add(titlePanel, BorderLayout.NORTH);

        JPanel actionsPanel = new JPanel();
        actionsPanel.setOpaque(false);
        BoxLayout actionsPanelLayout = new BoxLayout(actionsPanel, BoxLayout.Y_AXIS);
        actionsPanel.setLayout(actionsPanelLayout);
        String[] stages = { "stage1", "stage2", "stage3", "stage4", "stage5", "stage6", "stage7", "stage8" };
        actionsPanel.add(creatComboBoxPanel("ステージを選択", stages, (e) -> {
            String selectedStage = (String) ((JComboBox<?>) e.getSource()).getSelectedItem();
            App.getGameOverModel().setOpen(false);
            switch (selectedStage) {
                case "stage1":
                    App.getStageModel().setWorld(App.worldLevel1);
                    App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                    break;
                case "stage2":
                    App.getStageModel().setWorld(App.worldLevel2);
                    App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                    break;
                case "stage3":
                    App.getStageModel().setWorld(App.worldLevel3);
                    App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                    break;
                case "stage4":
                    App.getStageModel().setWorld(App.worldLevel4);
                    App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                    break;
                case "stage5":
                    App.getStageModel().setWorld(App.worldLevel5);
                    App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                    break;
                case "stage6":
                    App.getStageModel().setWorld(App.worldLevel6);
                    App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                    break;
                case "stage7":
                    App.getStageModel().setWorld(App.worldLevel7);
                    App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                    break;
                case "stage8":
                    App.getStageModel().setWorld(App.worldLevel8);
                    App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected value: " + selectedStage);
            }
        }));
        actionsPanel.add(createButtonPanel("レベル設定画面へ", "GO", controller::handleClickGoLevelSelect));
        actionsPanel.add(createButtonPanel("設定", "設定", controller::handleClickGoSetting));
        JPanel actionsWrapperPanel = new JPanel();
        actionsWrapperPanel.setLayout(new FlowLayout());
        actionsWrapperPanel.setOpaque(false);
        actionsWrapperPanel.add(actionsPanel);
        add(actionsWrapperPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        GridLayout bottomPanelLayout = new GridLayout(1, 2);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanel.setOpaque(false);
        bottomPanel.setPreferredSize(new Dimension(350, 50));
        JButton backButton = new JButton("戻る");
        backButton.addActionListener(controller::handleClose);
        JButton exitButton = new JButton("タイトルへ");
        exitButton.addActionListener(controller::handleClickExit);

        bottomPanel.add(backButton);
        bottomPanel.add(exitButton);
        JPanel bottomWrapperPanel = new JPanel();
        bottomWrapperPanel.setOpaque(false);
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
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(350, 50));
        JLabel label = new JLabel(labelText);
        panel.add(label, BorderLayout.WEST);
        JButton button = new JButton(buttonText);
        button.setPreferredSize(new Dimension(150, 50));
        button.addActionListener(actionListener);
        panel.add(button, BorderLayout.EAST);
        return panel;
    }

    private JPanel creatComboBoxPanel(String labelText, String[] items, ActionListener actionListener) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(350, 50));
        JLabel label = new JLabel(labelText);
        panel.add(label, BorderLayout.WEST);
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setPreferredSize(new Dimension(150, 50));
        comboBox.addActionListener(actionListener);
        panel.add(comboBox, BorderLayout.EAST);
        return panel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Views.paintBackground(g, WIDTH, HEIGHT);
    }

}
