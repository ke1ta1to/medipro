package views.game;

import java.awt.CardLayout;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

  public static final String PANEL_GAME = "game";

  private CardLayout layout;

  public GameFrame() {
    setTitle("Test Game");
    setSize(800, 600);
    layout = new CardLayout();
    setLayout(layout);
    add(new GamePanel(), PANEL_GAME);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public void showPanel(String panelName) {
    layout.show(getContentPane(), panelName);
  }
}
