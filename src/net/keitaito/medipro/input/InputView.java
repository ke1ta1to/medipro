package net.keitaito.medipro.input;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.keitaito.medipro.input_command_menu.InputCommandMenuView;
import net.keitaito.medipro.utils.Fonts;

public class InputView extends JPanel {

    private final InputModel model;
    private final InputController controller;

    private InputCommandMenuView inputCommandMenuView;
    JPanel openMenuButtonPanel;

    private final JTextArea textArea;

    public InputView(InputModel model, InputController controller) {
        this.model = model;
        this.controller = controller;

        BorderLayout layout = new BorderLayout();
        layout.setVgap(10);
        setLayout(layout);

        JButton openMenuButton = new JButton("コマンド一覧");
        openMenuButton.setFont(Fonts.MPLUS1CODE_FONT.deriveFont(20.0f));
        openMenuButtonPanel = new JPanel();
        openMenuButtonPanel.setOpaque(false);
        openMenuButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        openMenuButtonPanel.add(openMenuButton);
        openMenuButtonPanel.setVisible(true);
        openMenuButtonPanel.setSize(openMenuButtonPanel.getPreferredSize());
        openMenuButton.addActionListener(controller::handleClickOpenMenuButton);
        openMenuButtonPanel.setLocation(250 - openMenuButtonPanel.getWidth(), 0);
        add(openMenuButtonPanel);

        setPreferredSize(new Dimension(250, 0));

        textArea = new JTextArea();
        textArea.setFont(Fonts.MPLUS1CODE_FONT.deriveFont(Font.PLAIN, 16));
        textArea.getDocument().addDocumentListener(controller.getTextChangeListener(textArea));
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);

        JButton submitButton = new JButton("実行");
        submitButton.setFont(Fonts.STICK_FONT.deriveFont(Font.PLAIN, 24));
        submitButton.addActionListener(controller::handleSubmit);
        add(submitButton, BorderLayout.SOUTH);

        model.addPropertyChangeListener("text", this::updateText);
        model.addPropertyChangeListener("openedMenu", this::handleChangeMenuOpened);
    }

    public void setInputCommandMenuView(InputCommandMenuView view) {
        this.inputCommandMenuView = view;
        view.setBounds(200, 150, 400, 300);
        view.setVisible(false);
        add(view, BorderLayout.EAST);
    }

    private void handleChangeMenuOpened(PropertyChangeEvent event) {
        if ((boolean) event.getNewValue()) {
            inputCommandMenuView.setVisible(true);
            openMenuButtonPanel.setVisible(false);
            inputCommandMenuView.requestFocus();
        } else {
            inputCommandMenuView.setVisible(false);
            openMenuButtonPanel.setVisible(true);
            requestFocus();
        }
    }

    public InputModel getModel() {
        return model;
    }

    public InputController getController() {
        return controller;
    }

    private void updateText(PropertyChangeEvent evt) {
        String newText = (String) evt.getNewValue();
        if (!textArea.getText().equals(newText)) {
            textArea.setText((String) evt.getNewValue());
        }
    }

}
