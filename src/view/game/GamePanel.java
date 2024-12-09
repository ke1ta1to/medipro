package view.game;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import view.game.panels.CommandPanel;
import view.game.panels.GameCanvas;

public class GamePanel extends JPanel {

  public GamePanel() {
    setLayout(new BorderLayout());
    add(new GameCanvas(), BorderLayout.CENTER);
    add(new CommandPanel(), BorderLayout.WEST);
  }
}
