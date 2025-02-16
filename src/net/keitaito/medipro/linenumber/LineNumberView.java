package net.keitaito.medipro.linenumber;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;
import java.awt.*;

public class LineNumberView extends JComponent {
    private final JTextArea textArea;

    public LineNumberView(JTextArea textArea) {
        this.textArea = textArea;
        setPreferredSize(new Dimension(40, Integer.MAX_VALUE)); // 横幅40px
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

        FontMetrics fm = textArea.getFontMetrics(textArea.getFont());
        int lineHeight = fm.getHeight();
        int startOffset = textArea.getInsets().top + fm.getAscent();
        Element root = textArea.getDocument().getDefaultRootElement();

        // 背景を塗る（視認性向上）
        g2.setColor(new Color(245, 244, 228)); // textAreaと同じ背景色
        g2.fillRect(0, 0, getWidth(), getHeight());

        // 行番号の描画
        g2.setColor(Color.GRAY);
        for (int i = 0; i < root.getElementCount(); i++) {
            int y = startOffset + i * lineHeight;
            g2.drawString(String.valueOf(i + 1), 5, y);
        }
    }
}
