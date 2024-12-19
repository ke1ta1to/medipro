package views.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controllers.StageController;
import models.LanguageModel;
import models.StageModel;
import models.StateModel;

public class GamePanel extends JPanel {

    public GamePanel() {
        setLayout(new BorderLayout());

        LanguageModel languageModel = new LanguageModel();
        Image image = new ImageIcon(GamePanel.class.getResource("/images/character.png")).getImage();
        StateModel stateModel = new StateModel(200, 200, image);
        StageModel stageModel = new StageModel(stateModel, languageModel);
        StageController stageController = new StageController(stageModel);

        StagePanel stagePanel = new StagePanel(stageModel, stageController);
        stagePanel.setPreferredSize(new Dimension(800, 600));

        CommandPanel commandPanel = new CommandPanel(stageModel, stageController);
        commandPanel.setPreferredSize(new Dimension(250, 0));

        DebugPanel debugPanel = new DebugPanel(stateModel, stageModel);
        debugPanel.setPreferredSize(new Dimension(0, 100));

        add(stagePanel, BorderLayout.CENTER);
        add(commandPanel, BorderLayout.WEST);
        add(debugPanel, BorderLayout.SOUTH);
    }

}
