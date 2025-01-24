package medipro.top;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import medipro.App;

public class TopController implements ActionListener {
    private TopModel model;

    public TopController(TopModel model) {
        this.model = model;
    }

    public TopModel getModel() {
        return model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New Game Start":
                App.getWorldSubject().setWorld(App.worldLevel1);
                App.getCardSubject().setCardNumber(App.GAME_VIEW);
                break;

            case "Level Select":
                App.getCardSubject().setCardNumber(App.LEVEL_VIEW);
                break;

            case "Setting":
                App.getCardSubject().setCardNumber(App.SETTING_VIEW);
                break;

            case "How to Play":
                App.getCardSubject().setCardNumber(App.HOW_TO_PLAY);
                break;

            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
