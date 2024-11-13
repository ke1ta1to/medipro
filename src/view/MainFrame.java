package view;

import javax.swing.JFrame;
import java.awt.Color;

public class MainFrame extends JFrame {

  public MainFrame() {
    setTitle("Test Game");
    setSize(800, 600);
    getContentPane().setBackground(Color.BLUE);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
}
