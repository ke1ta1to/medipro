package view;

import javax.swing.*;

import model.EditorModel;
import utils.PlayerFigure;

import java.awt.*;

public class MainFrame extends JFrame {

  public MainFrame() {
    setTitle("Test Game");
    setSize(800, 600);
    setLayout(new GridLayout(1, 2));
    getContentPane().setBackground(Color.BLUE);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    PlayerFigure playerFigure = new PlayerFigure();
    EditorModel editorModel = new EditorModel(playerFigure);
    TextEditorPanel texteditor = new TextEditorPanel(editorModel);
    add(texteditor);
    add(new JPanel());
    setVisible(true);
  }
}
