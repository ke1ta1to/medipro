package views.game.panels;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import models.entities.Player;

public class GameCanvas extends JPanel implements ActionListener {

  private Player player;

  public GameCanvas(Player player) {
    this.player = player;
    Timer timer = new Timer(1000 / 60, this);
    timer.start();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    player.draw(g);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    repaint();
  }
}
