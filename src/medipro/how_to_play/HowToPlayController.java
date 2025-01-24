package medipro.how_to_play;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import medipro.App;

public class HowToPlayController implements ActionListener {
    private final HowToPlayModel model;

    public HowToPlayController(HowToPlayModel model) {
        this.model = model;
    }

    public HowToPlayModel getModel() {
        return model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "exit":
                App.getCardSubject().setCardNumber(App.TOP_VIEW);
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
