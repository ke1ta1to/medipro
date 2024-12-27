package medipro.views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import medipro.controllers.GameController;
import medipro.models.GameModel;

public class GameView extends JPanel {

    public GameView(GameModel model, GameController controller) {
        setBackground(Color.RED);

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        StageView stageView = new StageView();
        add(stageView, BorderLayout.CENTER);
        CommandInputView commandInputView = new CommandInputView();
        add(commandInputView, BorderLayout.WEST);
    }

}
