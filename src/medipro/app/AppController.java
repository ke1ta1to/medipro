package medipro.app;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;


public class AppController implements ActionListener{

    private final AppModel model;
    private final CardLayout cardLayout;
    private final JPanel mainPanel;

    public AppController(AppModel model, CardLayout cardLayout, JPanel mainPanel) {
        this.model = model;
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
    }

    public AppModel getModel() {
        return model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New Game Start":
                cardLayout.show(mainPanel, "AppView");
                break;
            case "Level Select":
                //TODO::レベル選択
                break;
            case "Setting":
                //TODO::設定選択
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
