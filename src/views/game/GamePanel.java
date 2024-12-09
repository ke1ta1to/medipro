package views.game;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import views.game.panels.CommandPanel;
import views.game.panels.GameCanvas;

public class GamePanel extends JPanel {

  public GamePanel() {
    setLayout(new BorderLayout());
    add(new GameCanvas(), BorderLayout.CENTER);
    add(new CommandPanel(), BorderLayout.WEST);
  }
}
