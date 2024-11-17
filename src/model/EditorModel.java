package model;
import utils.PlayerFigure;

public class EditorModel {
    private PlayerFigure playerFigure;

    public EditorModel(PlayerFigure playerFigure){
        this.playerFigure = playerFigure;
    }

    public void compiletext(String text){
        String[] EditorText = text.split("\n");
        for(String line : EditorText){
            compile(line);
        }
    }

    public void compile(String text){
        String[] word = text.split(" ");
        if(word[0].equals("move")){
            if(word[1].equals("left")){
                playerFigure.MoveLeft();
            }else if(word[1].equals("right")){
                playerFigure.MoveRight();
            }else{
                System.out.println("compile Error");
            }
        }else{
            System.out.println("compile Error");
        }
    }
}
