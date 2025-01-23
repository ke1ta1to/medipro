package medipro.stage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import medipro.Entity;
import medipro.Vector2;
import medipro.World;
import medipro.stage_menu.StageMenuView;
import medipro.utils.Fonts;

public class StageView extends JPanel implements MouseListener {

    private final StageModel model;
    private final StageController controller;

    private StageMenuView stageMenuView;

    public StageView(StageModel model, StageController controller) {
        this.model = model;
        this.controller = controller;

        setLayout(null);

        JButton openMenuButton = new JButton("メニュー");
        openMenuButton.setFont(Fonts.MPLUS1CODE_FONT.deriveFont(20.0f));
        JPanel openMenuButtonPanel = new JPanel();
        openMenuButtonPanel.setOpaque(false);
        openMenuButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        openMenuButtonPanel.add(openMenuButton);
        openMenuButtonPanel.setSize(openMenuButtonPanel.getPreferredSize());
        openMenuButton.addActionListener((e) -> {
            stageMenuView.setVisible(true);
            stageMenuView.requestFocus();
            openMenuButtonPanel.setVisible(false);
            controller.clearKeys();
            stageMenuView.getController().getModel().setOnClose(() -> {
                stageMenuView.setVisible(false);
                openMenuButtonPanel.setVisible(true);
                requestFocus();
            });
        });
        openMenuButtonPanel.setLocation(800 - openMenuButtonPanel.getWidth(), 0);
        add(openMenuButtonPanel);

        World world = model.getWorld();
        setPreferredSize(new Dimension(world.getWidth(), world.getHeight()));
        addKeyListener(controller);
        setFocusable(true);
        addMouseListener(this);

        // 30fps
        Timer timer = new Timer(1000 / 30, (e) -> {
            repaint();
        });
        timer.start();
    }

    public void setStageMenuView(StageMenuView view) {
        this.stageMenuView = view;
        view.setBounds(200, 150, 400, 300);
        view.setVisible(false);
        add(view);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 背景の描画
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // ステージの描画
        for (int i = 0; i < model.getWorld().getTiles().length; i++) {
            for (int j = 0; j < model.getWorld().getTiles()[i].length; j++) {
                if (model.getWorld().getTiles()[i][j] != null) {
                    model.getWorld().getTiles()[i][j].draw(g);
                }
            }
        }

        // draw keys
        g.setColor(Color.CYAN);
        g.setFont(g.getFont().deriveFont(20.0f));
        g.drawString("Keys: " + model.getKeys(), 10, 40);

        Entity entity = model.getEntity();
        g.drawImage(entity.getImage(), (int) entity.getPosX(), (int) entity.getPosY(), entity.getWidth(),
                entity.getHeight(), this);
        // entityの周りを線で囲む
        g.setColor(Color.RED);
        g.drawRect((int) entity.getPosX(), (int) entity.getPosY(), entity.getWidth(), entity.getHeight());
        if (entity.isAlive() == false) {
            g.setColor(Color.RED);
            g.drawLine((int) entity.getPosX(), (int) entity.getPosY(), (int) entity.getPosX() + entity.getWidth(),
                    (int) entity.getPosY() + entity.getHeight());
            g.drawLine((int) entity.getPosX() + entity.getWidth(), (int) entity.getPosY(), (int) entity.getPosX(),
                    (int) entity.getPosY() + entity.getHeight());
        }

        // ハングワイヤーの描画
        if (model.getHangWire() != null) {
            g.setColor(Color.PINK);
            Vector2 hangWireStart = model.getHangWire().getStart();
            Vector2 hangWireEnd = model.getHangWire().getEnd();
            g.drawLine((int) hangWireStart.getX(), (int) hangWireStart.getY(), (int) hangWireEnd.getX(),
                    (int) hangWireEnd.getY());
        }

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

    public StageModel getModel() {
        return model;
    }

    public StageController getController() {
        return controller;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        requestFocus();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
