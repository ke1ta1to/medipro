package views.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import controllers.StageController;
import models.StageModel;

public class StageView extends JPanel implements ActionListener {

    private final StageModel stageModel;
    private final StageController stageController;

    public StageView(StageModel stageModel, StageController stageController) {
        setBackground(Color.WHITE);

        this.stageModel = stageModel;
        this.stageController = stageController;

        // 描画開始
        Timer timer = new Timer(1000 / 60, this);
        timer.start();
    }

    // 描画ループ（60fps）
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        stageModel.draw(g);
    }

}
