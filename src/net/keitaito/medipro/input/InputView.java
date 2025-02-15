package net.keitaito.medipro.input;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.beans.PropertyChangeEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.keitaito.medipro.utils.Fonts;

public class InputView extends JPanel {

    private final InputModel model;
    private final InputController controller;

    private final JTextArea textArea;

    private final JButton helpButton;

    public InputView(InputModel model, InputController controller) {
        this.model = model;
        this.controller = controller;

        setPreferredSize(new Dimension(250, 0));

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        textArea = new JTextArea();
        textArea.setFont(Fonts.MPLUS1CODE_FONT.deriveFont(Font.PLAIN, 16));
        textArea.getDocument().addDocumentListener(controller.getTextChangeListener(textArea));
        textArea.setBackground(new Color(0xf5f4e4));// テキストの背景色をf5f4e4に設定
        // textArea.setForeground(Color.WHITE); // テキストの文字色を白に設定
        // textArea.setCaretColor(Color.WHITE); // キャレットの色を白に設定
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);

        helpButton = new JButton();
        helpButton.setFont(Fonts.STICK_FONT.deriveFont(Font.PLAIN, 24));
        helpButton.addActionListener(controller::handleHelp);
        helpButton.setOpaque(false);
        helpButton.setContentAreaFilled(false);
        helpButton.setBorderPainted(false);
        ImageIcon helpIcon = new ImageIcon(
                getClass().getClassLoader().getResource("net/keitaito/medipro/images/hatena.png"));
        helpButton.setIcon(helpIcon);

        JButton submitButton = new JButton();
        submitButton.setFont(Fonts.STICK_FONT.deriveFont(Font.PLAIN, 24));
        submitButton.addActionListener(controller::handleSubmit); // ボタンが押されたときの処理を登録
        submitButton.setOpaque(false);
        submitButton.setContentAreaFilled(false);
        submitButton.setBorderPainted(false);
        ImageIcon submitIcon = new ImageIcon(
                getClass().getClassLoader().getResource("net/keitaito/medipro/images/execute.png"));
        submitButton.setIcon(submitIcon);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        // ボタンの背景色を2e3648に設定
        buttonPanel.setBackground(new Color(0x2e3648));
        buttonPanel.add(helpButton, BorderLayout.EAST);
        buttonPanel.add(submitButton, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        model.addPropertyChangeListener("text", this::updateText);
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
