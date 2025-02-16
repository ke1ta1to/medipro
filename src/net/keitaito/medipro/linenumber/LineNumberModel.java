package net.keitaito.medipro.linenumber;

import java.awt.FontMetrics;

import javax.swing.text.Element;
import javax.swing.JComponent;
import javax.swing.JTextArea;

public class LineNumberModel extends JComponent {
    private Element root;
    private FontMetrics fm;
    private int lineHeight;
    private int startOffset;
    private JTextArea textArea;

    public LineNumberModel(JTextArea textArea) {
        this.textArea = textArea;
        this.fm = textArea.getFontMetrics(this.textArea.getFont());
        this.lineHeight = this.fm.getHeight();
        this.root = this.textArea.getDocument().getDefaultRootElement();
        this.startOffset = this.textArea.getInsets().top + this.fm.getAscent();
    }

    public Element getRoot() {
        this.root = this.textArea.getDocument().getDefaultRootElement();
        return this.root;
    }

    public Element getRoot(JTextArea textArea) {
        this.textArea = textArea;
        this.root = this.textArea.getDocument().getDefaultRootElement();
        return this.root;
    }

    public int getStartOffset() {
        this.startOffset = this.textArea.getInsets().top + this.fm.getAscent();
        return this.startOffset;
    }

    public int getLineHeight() {
        this.lineHeight = this.fm.getHeight();
        return this.lineHeight;
    }

    public FontMetrics getFontMetrics() {
        this.fm = this.textArea.getFontMetrics(this.textArea.getFont());
        return this.fm;
    }
}
