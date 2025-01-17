package medipro.level;

import medipro.cardobserver.CardSubject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelController implements ActionListener {

    private final LevelModel model;

    public LevelController(LevelModel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Level 1":
                CardSubject.setCardNumber("GameViewLevel1");
                break;

            case "Level 2":
                CardSubject.setCardNumber("GameViewLevel2");
                break;

            case "Level 3":
                CardSubject.setCardNumber("GameViewLevel3");
                break;

            case "Level 4":
                CardSubject.setCardNumber("GameViewLevel4");
                break;

            case "Level 5":
                CardSubject.setCardNumber("GameViewLevel5");
                break;

            case "Level 6":
                CardSubject.setCardNumber("GameViewLevel6");
                break;

            case "Level 7":
                CardSubject.setCardNumber("GameViewLevel7");
                break;

            case "Level 8":
                CardSubject.setCardNumber("GameViewLevel8");
                break;

            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
