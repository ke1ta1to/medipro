package medipro.top;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import medipro.App;
import medipro.subjects.CardSubject;
import medipro.subjects.WorldSubject;

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
                WorldSubject.setWorld(App.worldLevel1);
                CardSubject.setCardNumber(App.GAME_VIEW);
                break;

            case "Level Select":
                CardSubject.setCardNumber("levelPanel");
                break;

            case "Setting":
                CardSubject.setCardNumber("setting");
                break;

            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
