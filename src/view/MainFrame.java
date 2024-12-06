package view;

import java.awt.Color;  
import java.awt.GridLayout;  

import javax.swing.JFrame;  
import javax.swing.JPanel;

import model.EditorModel;
import model.PlayerModel;
import utils.PlayerFigure;  

public class MainFrame extends JFrame {

  public MainFrame() {
    setTitle("Test Game");
    setSize(800, 600);
    setLayout(new GridLayout(1, 2));
    getContentPane().setBackground(Color.BLUE);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    PlayerFigure playerFigure= new PlayerFigure();
    PlayerModel playerModel = new PlayerModel(playerFigure,200,500);
    EditorModel editorModel = new EditorModel(playerModel);
    TextEditorPanel textEditor = new TextEditorPanel(editorModel);

    MainPanel mainPanel = new MainPanel(playerModel,playerFigure);
    add(textEditor);
    add(mainPanel);
    setVisible(true);
  }
}
