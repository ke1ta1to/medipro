package medipro.setting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import medipro.cardobserver.CardSubject;

public class SettingController implements ActionListener {
    private final SettingModel model;

    public SettingController(SettingModel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "exit":
                CardSubject.setCardNumber("StartScreen");
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
