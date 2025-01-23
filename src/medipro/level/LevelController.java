package medipro.level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import medipro.App;

public class LevelController implements ActionListener {

    private final LevelModel model;

    public LevelController(LevelModel model) {
        this.model = model;
    }

    public LevelModel getModel() {
        return model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Level 1":
                App.getWorldSubject().setWorld(App.worldLevel1);
                App.getCardSubject().setCardNumber(App.GAME_VIEW);
                break;

            case "Level 2":
                App.getWorldSubject().setWorld(App.worldLevel2);
                App.getCardSubject().setCardNumber(App.GAME_VIEW);
                break;

            case "Level 3":
                App.getWorldSubject().setWorld(App.worldLevel3);
                App.getCardSubject().setCardNumber(App.GAME_VIEW);
                break;

            case "Level 4":
                App.getWorldSubject().setWorld(App.worldLevel4);
                App.getCardSubject().setCardNumber(App.GAME_VIEW);
                break;

            case "Level 5":
                App.getWorldSubject().setWorld(App.worldLevel5);
                App.getCardSubject().setCardNumber(App.GAME_VIEW);
                break;

            case "Level 6":
                App.getWorldSubject().setWorld(App.worldLevel6);
                App.getCardSubject().setCardNumber(App.GAME_VIEW);
                break;

            case "Level 7":
                App.getWorldSubject().setWorld(App.worldLevel7);
                App.getCardSubject().setCardNumber(App.GAME_VIEW);
                break;

            case "Level 8":
                App.getWorldSubject().setWorld(App.worldLevel8);
                App.getCardSubject().setCardNumber(App.GAME_VIEW);
                break;

            case "exit":
                App.getCardSubject().setCardNumber(App.TOP_VIEW);
                break;

            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
