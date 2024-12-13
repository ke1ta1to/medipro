package models.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler {

  private Map<String, Command> commands;

  public CommandHandler() {
    commands = new HashMap<String, Command>();
  }

  public void register(String name, Command command) {
    // 既にコマンドが存在する場合は例外をスローする
    if (commands.containsKey(name)) {
      throw new IllegalArgumentException("Command already exists");
    }

    commands.put(name, command);
  }

  public void execute(String name) {
    // コマンドが存在しない場合は例外をスローする
    if (!commands.containsKey(name)) {
      throw new IllegalArgumentException("Command not found");
    }

    commands.get(name).execute();
  }
}
