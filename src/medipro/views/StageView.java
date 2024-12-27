package medipro.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class StageView extends JPanel implements ActionListener {

    private final Timer timer;

    public StageView() {
        setBackground(Color.PINK);
        setPreferredSize(new Dimension(600, 400));

        // 30fps
        timer = new Timer(1000 / 30, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // 現在時刻を表示
        g.setColor(Color.BLACK);
        g.drawString("現在時刻: " + System.currentTimeMillis(), 10, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}
