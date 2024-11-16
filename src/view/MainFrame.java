package view;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

  public MainFrame() {
    setTitle("Test Game");
    setSize(800, 600);
    setLayout(new GridLayout(1,2));
    getContentPane().setBackground(Color.BLUE);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    TextEditorPanel texteditor = new TextEditorPanel();
    add(texteditor);
    add(new JPanel());
    setVisible(true);
  }
}
