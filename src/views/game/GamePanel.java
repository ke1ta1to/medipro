package views.game;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.Timer;

import controllers.GameController;
import models.GameModel;
import models.entities.Player;
import views.game.panels.CommandPanel;
import views.game.panels.GameCanvas;

public class GamePanel extends JPanel {

  public GamePanel() {
    setLayout(new BorderLayout());

    Player player = new Player();
    GameModel model = new GameModel(player);
    GameController controller = new GameController(model, player);
    Timer timer = new Timer(10, controller);
    timer.start();
    add(new GameCanvas(player), BorderLayout.CENTER);
    add(new CommandPanel(controller, model), BorderLayout.WEST);
  }
}
