package net.keitaito.medipro.utils;

import java.awt.Color;
import java.awt.Graphics;

public final class Views {

    public static void paintBackground(Graphics g, int width, int height) {
        // draw border
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        // draw background
        int thickness = 2; // 枠線の太さ
        g.setColor(Color.WHITE);
        g.fillRect(thickness, thickness, width - thickness * 2, height - thickness * 2);
    }

}
