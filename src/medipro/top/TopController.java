package medipro.top;

import medipro.cardobserver.CardSubject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                // TODO: 設定選択の処理を追加
                break;

            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
