package view;

import java.awt.Color;  
import java.awt.GridLayout;  

import javax.swing.JFrame;  
import javax.swing.JPanel;

import model.EditorModel;
import utils.PlayerFigure;  

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
