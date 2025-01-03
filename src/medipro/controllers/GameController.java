package medipro.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import medipro.models.GameModel;

public class GameController implements ActionListener {

    private final GameModel model;

    private final Timer timer;

    public GameController(GameModel model) {
        this.model = model;
        // 50 tick per second
        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.getEntityActions().forEach(action -> action.tick(model.getEntity()));
    }

}
