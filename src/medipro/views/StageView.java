package medipro.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import medipro.controllers.StageController;
import medipro.models.StageModel;

public class StageView extends JPanel implements ActionListener {

    private final StageModel model;
    private final StageController controller;

    public StageView(StageModel model, StageController controller) {
        this.model = model;
        this.controller = controller;

        setPreferredSize(new Dimension(800, 600));

        // 30fps
        Timer timer = new Timer(1000 / 30, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // draw current from System.currentTimeMillis()
        g.setColor(Color.PINK);
        g.setFont(g.getFont().deriveFont(20.0f));
        g.drawString("Current: " + System.currentTimeMillis(), 10, 10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}
