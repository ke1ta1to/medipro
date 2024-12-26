package views.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controllers.StageController;
import models.EntityModel;
import models.LanguageModel;
import models.StageModel;

public class GameView extends JPanel {

    public GameView() {
        setLayout(new BorderLayout());

        LanguageModel languageModel = new LanguageModel();
        Image image = new ImageIcon(GameView.class.getResource("/images/character.png")).getImage();
        EntityModel entityModel = new EntityModel(200, 200, image);
        StageModel stageModel = new StageModel(entityModel, languageModel);
        StageController stageController = new StageController(stageModel);

        StageView stageView = new StageView(stageModel, stageController);
        stageView.setPreferredSize(new Dimension(800, 600));

        CommandView commandView = new CommandView(stageModel, stageController);
        commandView.setPreferredSize(new Dimension(250, 0));

        DebugView debugView = new DebugView(entityModel, stageModel);
        debugView.setPreferredSize(new Dimension(0, 100));

        add(stageView, BorderLayout.CENTER);
        add(commandView, BorderLayout.WEST);
        add(debugView, BorderLayout.SOUTH);
    }

}
