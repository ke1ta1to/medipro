package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import models.StageModel;

public class StageController implements ActionListener {

    private final StageModel model;
    private final Timer timer;

    public StageController(StageModel model) {
        this.model = model;
        this.timer = new Timer(1, this);
    }

    public void start() {
        timer.start();
    }

    public void reset() {
        timer.stop();
        model.reset();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.tick();
    }

}
