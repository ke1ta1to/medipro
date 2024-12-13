package models.commands;

import models.entities.Player;

public class LeftCommand extends Command {

  private Player player;

  public LeftCommand(Player player) {
    this.player = player;
  }

  @Override
  public void execute() {
    System.out.println("left command");
    player.setRight(false);
    player.setLeft(true);
  }

}
