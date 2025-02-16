package net.keitaito.medipro.input;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.Element;

import net.keitaito.medipro.linenumber.LineNumberModel;
import net.keitaito.medipro.linenumber.LineNumberView;
import net.keitaito.medipro.utils.Fonts;

public class InputView extends JPanel {

    private final InputModel model;
    private final InputController controller;

    private final JTextArea textArea;

    private final JButton helpButton;

    private Element root;
    private int lineHeight;
    private int startOffset;

    public InputView(InputModel model, InputController controller) {
        this.model = model;
        this.controller = controller;

        setPreferredSize(new Dimension(250, 0));

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        textArea = new JTextArea();
        textArea.setFont(Fonts.MPLUS1CODE_FONT.deriveFont(Font.PLAIN, 16));
        textArea.getDocument().addDocumentListener(controller.getTextChangeListener(textArea));
        textArea.setBackground(new Color(245, 244, 228));// テキストの背景色をrgb(245,244,228)に設定
        // textArea.setForeground(Color.WHITE); // テキストの文字色を白に設定
        // textArea.setCaretColor(Color.WHITE); // キャレットの色を白に設定
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setRowHeaderView(new LineNumberView(textArea)); // 行番号を表示
        textArea.setLineWrap(true); // テキストがコンポーネントの幅を超えたときに折り返す

        model.setInputTextData(textArea);

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
        buttonPanel.setBackground(new Color(0x2e3648)); // ボタンの背景色を2e3648に設定
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

    // 指定された「行まで」の背景色を変更する
    public void setMultiLineBackgroundColor(Graphics g, Color color, int line) {
        model.setInputTextData(textArea);
        this.startOffset = model.getStartOffset();
        this.lineHeight = model.getLineHeight();
        int y = this.startOffset + line * this.lineHeight;
        g.setColor(color);
        g.fillRect(0, 0, getWidth(), y);
    }

    // 指定された「行」の背景色を変更する
    public void setSingleLineBackgroundColor(Graphics g, Color color, int line) {
        model.setInputTextData(textArea);
        this.startOffset = model.getStartOffset();
        this.lineHeight = model.getLineHeight();
        int y = this.startOffset + line * this.lineHeight;
        g.setColor(color);
        g.fillRect(0, y, getWidth(), this.lineHeight);
    }

    // 指定された「行まで」の文字列のみをハイライトする
    public void setMultiLineCharacterColor(Graphics g, Color color, int line) {
        model.setInputTextData(textArea);
        this.startOffset = model.getStartOffset();
        this.lineHeight = model.getLineHeight();
        int y = this.startOffset;
        g.setColor(color);
        String[] lines = textArea.getText().split("\n"); // 改行で分割

        for (int i = 0; i < line; i++) {
            int width = this.model.getStringWidth(lines[i]);
            y = this.startOffset + i * this.lineHeight;
            g.fillRect(0, y, width, this.lineHeight); // ハイライト
            g.setColor(Color.BLACK);
            g.drawString(lines[i], 0, y);
        }
    }

    // 指定された「行」の文字列をハイライトする
    public void setSingleLineCharacterColor(Graphics g, Color color, int line) {
        model.setInputTextData(textArea);
        this.startOffset = model.getStartOffset();
        this.lineHeight = model.getLineHeight();
        int y = this.startOffset + line * this.lineHeight;
        g.setColor(color);
        String[] lines = textArea.getText().split("\n"); // 改行で分割

        int width = this.model.getStringWidth(lines[line]);
        g.fillRect(0, y, width, this.lineHeight);
        g.setColor(Color.BLACK);
        g.drawString(lines[line], 0, y);
    }
}
