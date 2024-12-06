package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.PlayerModel;
import utils.PlayerFigure;

public class MainPanel  extends JPanel implements ActionListener {
    private JPanel panel;
    private Timer timer;
    private Graphics player;
    private int x,y,wid,hei;
    private PlayerModel playerModel;
    private PlayerFigure playerFigure;
    public MainPanel(PlayerModel playerModel,PlayerFigure playerFigure) {
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        timer = new Timer(10,this);
        timer.start();
        x = 200;//初期座標x
        y = 500;//初期座標y
        wid = 10;
        hei = 10;
        this.playerFigure = playerFigure;
        this.playerModel = playerModel;
        playerFigure.setX(x);
        playerFigure.setY(y);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // 親クラスの描画を呼び出す
        player = (Graphics) g;
        player.setColor(Color.BLACK);
        player.fillRect(playerFigure.getX(), playerFigure.getY(), wid, hei);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(playerModel.isMoveLeft){
            playerFigure.moveLeft();
            playerModel.x=playerFigure.getX();
        }
        if(playerModel.isMoveRight){
            playerFigure.moveRight();
            playerModel.x=playerFigure.getX();
        }
        repaint();
    }
}