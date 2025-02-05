package net.keitaito.medipro.components;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;

import net.keitaito.medipro.utils.Fonts;

public class TitleButton extends JButton {

    public TitleButton(String text) {
        super(text);
        setFont(Fonts.STICK_FONT.deriveFont(Font.PLAIN, 20));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

}
