package medipro.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import medipro.models.StageModel;

public class StageController implements KeyListener, ActionListener {

    private final StageModel model;

    public StageController(StageModel model) {
        this.model = model;

        // 20tps
        Timer timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        String key = String.valueOf(e.getKeyChar()).toLowerCase();
        model.addKey(key);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String key = String.valueOf(e.getKeyChar()).toLowerCase();
        model.removeKey(key);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.tick();
    }

    public StageModel getModel() {
        return model;
    }

}
