package medipro.app;

import java.awt.CardLayout;

import javax.swing.JPanel;

import medipro.cardobserver.CardSubject;

public class AppController {

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
}
