package medipro.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import medipro.controllers.StageController;
import medipro.models.StageModel;

public class StageView extends JPanel {

    private final StageModel model;
    // private final StageController controller;

    public StageView(StageModel model, StageController controller) {
        this.model = model;
        // this.controller = controller;

        setPreferredSize(new Dimension(800, 600));
        addKeyListener(controller);
        setFocusable(true);

        // 30fps
        Timer timer = new Timer(1000 / 30, (e) -> {
            repaint();
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // DEBUG

        // draw keys
        g.setColor(Color.CYAN);
        g.setFont(g.getFont().deriveFont(20.0f));
        g.drawString("Keys: " + model.getKeys(), 10, 40);

        ImageIcon icon = new ImageIcon(getClass().getResource("/medipro/risaju.png"));
        Image image = icon.getImage();
        g.drawImage(image, (int) model.getEntity().getPosX(), (int) model.getEntity().getPosY(), 100, 100, this);

        // stage
        g.setColor(Color.BLACK);
        g.fillRect(0, 200, 800, 1);

        // entity data
        g.setColor(Color.RED);
        g.setFont(g.getFont().deriveFont(20.0f));
        g.drawString("posX: " + model.getEntity().getPosX(), 10, 70);
        g.drawString("posY: " + model.getEntity().getPosY(), 10, 100);
        g.drawString("velX: " + model.getEntity().getVelX(), 10, 130);
        g.drawString("velY: " + model.getEntity().getVelY(), 10, 160);
        g.drawString("accX: " + model.getEntity().getAccX(), 10, 190);
        g.drawString("accY: " + model.getEntity().getAccY(), 10, 220);
    }

}
