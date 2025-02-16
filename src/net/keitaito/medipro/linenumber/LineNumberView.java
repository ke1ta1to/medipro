package net.keitaito.medipro.linenumber;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.text.Element;

import net.keitaito.medipro.linenumber.LineNumberModel;

public class LineNumberView extends JComponent {
    private final JTextArea textArea;
    private Element root;
    private LineNumberModel model;

    public LineNumberView(JTextArea textArea) {
        this.textArea = textArea;
        this.model = new LineNumberModel(textArea);
        setPreferredSize(new Dimension(40, 0)); // 横幅40px
        setFont(textArea.getFont());

        // 行番号の自動更新
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                repaint();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                repaint();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                repaint();
            }
        });

        // スクロール時に行番号を同期
        textArea.addCaretListener(e -> repaint());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int lineHeight = this.model.getLineHeight(textArea); // 行の高さ
        int startOffset = this.model.getStartOffset(); // 開始オフセット
        this.root = this.model.getRoot(); // ルート要素

        // 背景を塗る
        g2.setColor(new Color(245, 244, 228)); // textAreaと同じ背景色
        g2.fillRect(0, 0, getWidth(), getHeight());

        // 行番号の描画
        g2.setColor(Color.GRAY);
        for (int i = 0; i < root.getElementCount(); i++) {
            int y = startOffset + i * lineHeight;
            g2.drawString(String.valueOf(i + 1), 5, y);
        }
    }

    // 指定された「行まで」の文字色を変更
    protected void setMultiLineCharacterColor(Graphics g, Color color, int row) {
        int lineHeight = model.getLineHeight(textArea);
        int startOffset = model.getStartOffset();
        int y = startOffset + row * lineHeight;
        g.setColor(color);
        for (int i = 0; i < root.getElement(row).getEndOffset(); i++) {
            g.drawString(String.valueOf(i + 1), 5, y);
        }
    }

    // 指定された「行」の文字色を変更
    protected void setSingleLineCharacterColor(Graphics g, Color color, int row) {
        int lineHeight = model.getLineHeight(textArea);
        int startOffset = model.getStartOffset();
        int y = startOffset + row * lineHeight;
        g.setColor(color);
        g.drawString(String.valueOf(row + 1), 5, y);
    }
}
