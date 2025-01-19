package medipro.top;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import medipro.cardobserver.CardSubject;

public class TopController implements ActionListener {
    private TopModel model;

    public TopController(TopModel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New Game Start":
                CardSubject.setCardNumber("GameViewLevel1");
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
