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
                model.setSelectedLevel(1);
                break;

            case "Level 2":
                App.getWorldSubject().setWorld(App.worldLevel2);
                App.getCardSubject().setCardNumber(App.GAME_VIEW);
                model.setSelectedLevel(2);
                break;

            case "Level 3":
                App.getWorldSubject().setWorld(App.worldLevel3);
                App.getCardSubject().setCardNumber(App.GAME_VIEW);
                model.setSelectedLevel(3);
                break;

            case "Level 4":
                App.getWorldSubject().setWorld(App.worldLevel4);
                App.getCardSubject().setCardNumber(App.GAME_VIEW);
                model.setSelectedLevel(4);
                break;

            case "Level 5":
                App.getWorldSubject().setWorld(App.worldLevel5);
                App.getCardSubject().setCardNumber(App.GAME_VIEW);
                model.setSelectedLevel(5);
                break;

            case "Level 6":
                App.getWorldSubject().setWorld(App.worldLevel6);
                App.getCardSubject().setCardNumber(App.GAME_VIEW);
                model.setSelectedLevel(6);
                break;

            case "Level 7":
                App.getWorldSubject().setWorld(App.worldLevel7);
                App.getCardSubject().setCardNumber(App.GAME_VIEW);
                model.setSelectedLevel(7);
                break;

            case "Level 8":
                App.getWorldSubject().setWorld(App.worldLevel8);
                App.getCardSubject().setCardNumber(App.GAME_VIEW);
                model.setSelectedLevel(8);
                break;

            case "exit":
                App.getCardSubject().setCardNumber(App.TOP_VIEW);
                break;

            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
        // ystem.out.println("Selected Level " + model.getSelectedLevel());
    }
}
