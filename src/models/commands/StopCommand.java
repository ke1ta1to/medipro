package models.commands;

import models.entities.Player;

public class StopCommand extends Command {
  private Player player;

  public StopCommand(Player player) {
    this.player = player;
  }

  @Override
  public void execute() {
    System.out.println("stop command");
    player.setRight(false);
    player.setLeft(false);
  }
}
