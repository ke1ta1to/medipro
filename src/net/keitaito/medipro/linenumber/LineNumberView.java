package net.keitaito.medipro.linenumber;

import javax.swing.JTextArea;

public class LineNumberView {
    private final JTextArea textArea;

    public LineNumberView(JTextArea textArea) {
        this.textArea = textArea;
        this.textArea.setFont(textArea.getFont());
        setForeground(Color.GRAY);
        setPreferredSize(new Dimension(30, Integer.MAX_VALUE)); // 横幅30px
    }
}
