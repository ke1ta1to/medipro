package views.game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import models.EntityModel;
import models.EntityStatusModel;
import models.StageModel;

public class DebugPanel extends JPanel implements ActionListener {

    private final EntityModel stateModel;
    private final StageModel stageModel;

    public DebugPanel(EntityModel stateModel, StageModel stageModel) {
        this.stateModel = stateModel;
        this.stageModel = stageModel;

        setBorder(javax.swing.BorderFactory.createTitledBorder("デバッグ情報"));

        Timer timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        EntityStatusModel currentStateLayer = stageModel.getCurrentStateLayer();

        g.drawString(stateModel.toShortString(), 10, 30);
        g.drawString(stageModel.toString(), 10, 50);
        if (currentStateLayer != null)
            g.drawString(currentStateLayer.toString(), 10, 70);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}
