package medipro.level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import medipro.App;
import medipro.subjects.CardSubject;
import medipro.subjects.WorldSubject;

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
                WorldSubject.setWorld(App.worldLevel1);
                CardSubject.setCardNumber(App.GAME_VIEW);
                break;

            case "Level 2":
                WorldSubject.setWorld(App.worldLevel2);
                CardSubject.setCardNumber(App.GAME_VIEW);
                break;

            case "Level 3":
                CardSubject.setCardNumber(App.GAME_VIEW);
                break;

            case "Level 4":
                CardSubject.setCardNumber(App.GAME_VIEW);
                break;

            case "Level 5":
                CardSubject.setCardNumber(App.GAME_VIEW);
                break;

            case "Level 6":
                CardSubject.setCardNumber(App.GAME_VIEW);
                break;

            case "Level 7":
                CardSubject.setCardNumber(App.GAME_VIEW);
                break;

            case "Level 8":
                CardSubject.setCardNumber(App.GAME_VIEW);
                break;

            case "exit":
                CardSubject.setCardNumber(App.TOP_VIEW);
                break;

            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
