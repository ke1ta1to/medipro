package models.commands;

import models.entities.Player;

public class RightCommand extends Command {

  private Player player;

  public RightCommand(Player player) {
    this.player = player;
  }

  @Override
  public void execute() {
    System.out.println("right command");
    player.setRight(true);
    player.setLeft(false);
  }

}
