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

    private final EntityModel entityModel;
    private final StageModel stageModel;

    public DebugPanel(EntityModel entityModel, StageModel stageModel) {
        this.entityModel = entityModel;
        this.stageModel = stageModel;

        setBorder(javax.swing.BorderFactory.createTitledBorder("デバッグ情報"));

        Timer timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        EntityStatusModel currentEntityStatusModel = stageModel.getCurrentEntityStatusModel();

        g.drawString(entityModel.toShortString(), 10, 30);
        g.drawString(stageModel.toString(), 10, 50);
        if (currentEntityStatusModel != null)
            g.drawString(currentEntityStatusModel.toString(), 10, 70);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}
