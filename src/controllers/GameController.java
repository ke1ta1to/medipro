package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.GameModel;
import models.entities.Player;

public class GameController implements ActionListener {

  private GameModel model;
  private Player player;
  int index = 0;

  String inputs = "right\nleft";
  String[] lines = inputs.split("\n");

  public GameController(GameModel model, Player player) {
    this.model = model;
    this.player = player;
  }

  private void loadCommand() {
    // タイマーが呼び出す
    if (lines.length <= index)
      return;
    String command = lines[index];
    model.getCommandHandler().execute(command);
    index++;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    loadCommand();
    player.printLocation();
    player.move();
  }

}
