package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

  public GameFrame() {
    setTitle("Test Game");
    setSize(800, 600);
    setLayout(new GridLayout(1, 2));
    getContentPane().setBackground(Color.BLUE);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
}
