package net.keitaito.medipro.input;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;

import javax.swing.text.DefaultHighlighter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import net.keitaito.medipro.linenumber.LineNumberView;
import net.keitaito.medipro.utils.Fonts;

public class InputView extends JPanel {

    private final InputModel model;
    private final InputController controller;

    private final JTextArea textArea;

    private final JButton helpButton;

    private int lineHeight;
    private int startOffset;
    private int currentLine = -1; // 現在強調表示されている行

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

        model.addPropertyChangeListener("update", evt -> {
            Object newValue = evt.getNewValue();
            if (newValue instanceof Integer) {
                int newLine = (int) newValue;
                int maxLines = textArea.getText().split("\n").length; // 現在の行数を取得

                if (newLine < maxLines) { // 範囲外のインデックスにアクセスしない
                    currentLine = newLine;
                    highlightLine(currentLine);
                    repaint(); // 再描画をトリガー
                } else {
                    System.err.println("Warning: currentLine exceeds maxLines: " + newLine);
                }
            }
        });

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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentLine >= 0) {
            update(g);
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
    public void setMultiLineHighlight(Graphics g, Color color1, Color color2, int line) {
        if (line < 0)
            return;
        model.setInputTextData(textArea);
        this.startOffset = model.getStartOffset();
        this.lineHeight = model.getLineHeight();
        int y = this.startOffset;
        g.setColor(color1);
        String[] lines = textArea.getText().split("\n"); // 改行で分割

        g.setColor(color2);
        for (int i = 0; i < line; i++) {
            int width = this.model.getStringWidth(lines[i]);
            y = this.startOffset + i * this.lineHeight;
            g.fillRect(0, y, width, this.lineHeight); // ハイライト
            g.drawString(lines[i], 0, y);
        }
    }

    // 指定された「行」の文字列をハイライトする
    public void setSingleLineHighlight(Graphics g, Color color1, Color color2, int line) {
        model.setInputTextData(textArea);
        this.startOffset = model.getStartOffset();
        this.lineHeight = model.getLineHeight();
        int y = this.startOffset + line * this.lineHeight;
        g.setColor(color1);
        String[] lines = textArea.getText().split("\n"); // 改行で分割

        int width = this.model.getStringWidth(lines[line]);
        g.fillRect(0, y, width, this.lineHeight);
        g.setColor(color2);
        g.drawString(lines[line], 0, y);
    }

    // テキストエリアの背景色,ハイライトをリセットする
    public void reset(Graphics g) {
        model.setInputTextData(textArea);
        this.startOffset = model.getStartOffset();
        this.lineHeight = model.getLineHeight();
        g.setColor(new Color(245, 244, 228));
        g.fillRect(0, 0, getWidth(), getHeight());

        textArea.setForeground(Color.BLACK);
        textArea.setText(textArea.getText());
        // currentLine = -1;
    }

    // 読み込まれる行が更新される度に呼び出されるコードの強調表示を行う
    public void update(Graphics g) {
        setMultiLineBackgroundColor(g, new Color(226, 226, 210), currentLine); // rgb(226, 226, 210)
        g.setColor(Color.BLACK);
        // rgb(218, 171, 181) rgb(114, 86, 97)
        setMultiLineHighlight(g, new Color(218, 171, 181), new Color(114, 86, 97), currentLine - 1);
        // rgb(200, 92, 122) rgb(117, 67, 79)
        setSingleLineHighlight(g, new Color(200, 92, 122), new Color(117, 67, 79), currentLine);
        System.out.println("実行中の行: " + currentLine);
        // currentLine++;
    }

    private void highlightLine(int line) {
        try {
            textArea.getHighlighter().removeAllHighlights(); // 既存のハイライトを削除
            String[] lines = textArea.getText().split("\n");

            if (line >= lines.length)
                return; // 範囲外なら何もしない

            // すでに処理した行をピンク rgb(218, 171, 181) でハイライト
            if (line > 0) {
                int startOffset = textArea.getLineStartOffset(0);
                int endOffset = textArea.getLineEndOffset(line - 1);

                textArea.getHighlighter().addHighlight(startOffset, endOffset,
                        new DefaultHighlighter.DefaultHighlightPainter(new Color(218, 171, 181)));
                System.out.println("ハイライト（過去の行）: 0 〜 " + (line - 1));
            }

            // 現在の行を赤 rgb(200, 92, 122) でハイライト
            int startOffset = textArea.getLineStartOffset(line);
            int endOffset = textArea.getLineEndOffset(line);

            textArea.getHighlighter().addHighlight(startOffset, endOffset,
                    new DefaultHighlighter.DefaultHighlightPainter(new Color(200, 92, 122)));
            System.out.println("ハイライト（現在の行）: " + line);

        } catch (Exception e) {
            System.err.println("エラー発生: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
