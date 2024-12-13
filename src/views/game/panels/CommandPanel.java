package views.game.panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import controllers.GameController;
import models.GameModel;

public class CommandPanel extends JPanel {

  private GameController controller;
  private GameModel model;

  public CommandPanel(GameController controller, GameModel model) {
    setPreferredSize(new Dimension(200, 0));
    setBackground(Color.RED);
  }
}
