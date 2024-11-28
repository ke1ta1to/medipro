package view;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.PlayerFigure;
import model.PlayerModel;

public class MainPanel  extends JPanel implements ActionListener {
    private JPanel _panel;
    private Timer timer;
    private Graphics player;
    private int x,y,wid,hei;
    private PlayerModel playermodel;
    private PlayerFigure playerfigure;
    public MainPanel(PlayerModel playermodel,PlayerFigure playerfigure) {
        _panel = new JPanel();
        _panel.setLayout(new GridLayout(1, 1));
        timer = new Timer(10,this);
        timer.start();
        x = 200;
        y = 500;
        wid = 10;
        hei = 10;
        this.playerfigure = playerfigure;
        this.playermodel = playermodel;
        playerfigure.setX(x);
        playerfigure.setY(y);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // 親クラスの描画を呼び出す
        player = (Graphics) g;
        player.setColor(Color.BLACK);
        player.fillRect(playerfigure.getX(), playerfigure.getY(), wid, hei);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(playermodel.IsMoveLeft){
            playerfigure.MoveLeft();
            playermodel.X=playerfigure.getX();
        }
        if(playermodel.IsMoveRight){
            playerfigure.MoveRight();
            playermodel.X=playerfigure.getX();
        }
        repaint();
    }
}