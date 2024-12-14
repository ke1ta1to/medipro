package models;

import models.commands.CommandHandler;
import models.commands.LeftCommand;
import models.commands.RightCommand;
import models.commands.StopCommand;
import models.entities.Player;

public class GameModel {

  private CommandHandler commandHandler;
  private Player player;

  public GameModel(Player player) {
    commandHandler = new CommandHandler();
    this.player = player;
    commandHandler.register("right", new RightCommand(player));
    commandHandler.register("left", new LeftCommand(player));
    commandHandler.register("stop", new StopCommand(player));

  }

  public CommandHandler getCommandHandler() {
    return commandHandler;
  }

  public Player getPlayer() {
    return player;
  }

}
