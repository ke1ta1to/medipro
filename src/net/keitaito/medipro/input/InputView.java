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
    private int highlightLine = -1; // ハイライトする1行
    private int highlightUntilLine = -1; // ここまでの行をハイライト

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
                    update(currentLine);
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

        int lineHeight = textArea.getFontMetrics(textArea.getFont()).getHeight();
        int startOffset = textArea.getInsets().top;

        g.setColor(new Color(226, 226, 210)); // マルチライン用の背景色rgb(226, 226, 210)
        if (highlightUntilLine >= 0) {
            int y = startOffset + highlightUntilLine * lineHeight;
            g.fillRect(0, 0, getWidth(), y);
        }

        // 使う予定なし
        g.setColor(new Color(200, 92, 122)); // シングルライン用の背景色rgb(200, 92, 122)
        if (highlightLine >= 0) {
            int y = startOffset + highlightLine * lineHeight;
            g.fillRect(0, y, getWidth(), lineHeight);
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
    public void setMultiLineBackgroundColor(int line) {
        this.highlightUntilLine = line;
        repaint(); // 再描画をトリガー
    }

    // 指定された「行」の背景色を変更する
    public void setSingleLineBackgroundColor(int line) {
        this.highlightLine = line;
        repaint(); // 再描画をトリガー
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
    public void update(int line) {
        setMultiLineBackgroundColor(line);
        highlightLine(line);
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
