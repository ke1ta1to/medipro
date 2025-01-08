package medipro.app;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class AppView extends JPanel {

    private final AppModel model;
    private final AppController controller;

    public AppView(AppModel model, AppController controller) {
        this.model = model;
        this.controller = controller;

        BorderLayout layout = new BorderLayout();
        setLayout(layout);
    }

    public void setStageView(JPanel view) {
        add(view, BorderLayout.CENTER);
    }

    public void setInputView(JPanel view) {
        add(view, BorderLayout.WEST);
    }

    public AppModel getModel() {
        return model;
    }

    public AppController getController() {
        return controller;
    }

}
