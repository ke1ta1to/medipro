package net.keitaito.medipro.stage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import net.keitaito.medipro.App;

public class StageController implements KeyListener, ActionListener {

    private final StageModel model;

    public StageController(StageModel model) {
        this.model = model;

        // 100tps
        Timer timer = new Timer(10, this);
        timer.start();
    }

    public void clearKeys() {
        model.clearKeys();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        model.addKey(key);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        model.removeKey(key);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.tick();
    }

    public StageModel getModel() {
        return model;
    }

    public void handleClickOpenMenuButton(ActionEvent event) {
        App.getStageMenuModel().setOpen(true);
    }

}
