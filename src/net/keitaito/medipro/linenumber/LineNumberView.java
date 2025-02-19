package net.keitaito.medipro.linenumber;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.text.Element;

public class LineNumberView extends JComponent {
    private final JTextArea textArea;
    private Element root;
    private LineNumberModel model;
    private int lineHeight;
    private int startOffset;

    public LineNumberView(JTextArea textArea) {
        this.textArea = textArea;
        this.model = new LineNumberModel(this.textArea);
        this.lineHeight = model.getLineHeight();
        this.startOffset = model.getStartOffset();
        this.root = model.getRoot();
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

        // 背景を塗る
        g2.setColor(new Color(245, 244, 228)); // textAreaと同じ背景色
        g2.fillRect(0, 0, getWidth(), getHeight());

        // 行番号の描画
        g2.setColor(Color.GRAY);
        for (int i = 0; i < root.getElementCount(); i++) {
            int y = this.startOffset + i * this.lineHeight;
            g2.drawString(String.valueOf(i + 1), 5, y);
        }
    }

    // 指定された「行まで」の文字色を変更rgb(226, 226, 210)
    protected void setMultiLineCharacterColor(Graphics g, Color color, int line) {
        int y = this.startOffset + line * this.lineHeight;
        g.setColor(color);
        for (int i = 0; i < root.getElement(line).getEndOffset(); i++) {
            g.drawString(String.valueOf(i + 1), 5, y);
        }
    }

    // 指定された「行」の文字色を変更
    protected void setSingleLineCharacterColor(Graphics g, Color color, int line) {
        int y = this.startOffset + line * this.lineHeight;
        g.setColor(color);
        g.drawString(String.valueOf(line + 1), 5, y);
    }

    // 指定した「行まで」の背景色を変更
    protected void setMultiLineBackgroundColor(Graphics g, Color color, int line) {
        int y = this.startOffset + line * this.lineHeight;
        g.setColor(color);
        g.fillRect(0, 0, getWidth(), y);
    }

    // 指定した「行」の背景色を変更
    protected void setSingleLineBackgroundColor(Graphics g, Color color, int line) {
        int y = this.startOffset + line * this.lineHeight;
        g.setColor(color);
        g.fillRect(0, y - this.lineHeight, getWidth(), this.lineHeight);
    }

    public void resetColor(Graphics g) {
        g.setColor(new Color(245, 244, 228));
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.GRAY);
        for (int i = 0; i < root.getElementCount(); i++) {
            int y = this.startOffset + i * this.lineHeight;
            g.drawString(String.valueOf(i + 1), 5, y);
        }
    }

    public void update(Graphics g, int line) {
        setMultiLineBackgroundColor(g, new Color(226, 226, 210), line);
        // 行番号の描画
        g.setColor(Color.GRAY);
        for (int i = 0; i < root.getElementCount(); i++) {
            int y = this.startOffset + i * this.lineHeight;
            g.drawString(String.valueOf(i + 1), 5, y);
        }

        repaint();
    }
}
