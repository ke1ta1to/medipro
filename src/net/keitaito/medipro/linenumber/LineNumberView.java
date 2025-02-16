package net.keitaito.medipro.linenumber;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.event.DocumentListener;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.text.Element;
import java.awt.Color;
import javax.swing.event.DocumentEvent;
import java.awt.FontMetrics;

public class LineNumberView extends JComponent {
    private final JTextArea textArea;

    public LineNumberView(JTextArea textArea) {
        this.textArea = textArea;
        this.textArea.setFont(textArea.getFont());
        this.textArea.setForeground(Color.RED); // 行番号の色を赤に設定
        this.textArea.setPreferredSize(new Dimension(30, 60)); // 横幅30px

        // JTextAreaの変更を監視して再描画
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

        FontMetrics fm = textArea.getFontMetrics(textArea.getFont());
        int lineHeight = fm.getHeight();
        int startOffset = textArea.getInsets().top + fm.getAscent(); // 行の開始位置を調整
        Element root = textArea.getDocument().getDefaultRootElement();

        // 背景を塗る（視認性向上）
        g2.setColor(new Color(245, 244, 228)); // textAreaと同じ背景色
        g2.fillRect(0, 0, getWidth(), getHeight());

        // 行番号の描画
        g2.setColor(Color.BLUE);
        for (int i = 0; i < root.getElementCount(); i++) {
            int y = startOffset + i * lineHeight;
            g2.drawString(String.valueOf(i + 1), 5, y);
        }
    }
}
