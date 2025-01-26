package net.keitaito.medipro.app;

import java.awt.CardLayout;
import java.beans.PropertyChangeEvent;

import javax.swing.JPanel;

public class AppView extends JPanel {

    private final AppModel model;
    private final AppController controller;

    public AppView(AppModel model, AppController controller) {
        this.model = model;
        this.controller = controller;

        model.addPropertyChangeListener("pageName", this::handleChangePageName);

        CardLayout layout = new CardLayout();
        setLayout(layout);
    }

    public void addView(JPanel view, String name) {
        add(view, name);
    }

    public AppModel getModel() {
        return model;
    }

    public AppController getController() {
        return controller;
    }

    private void handleChangePageName(PropertyChangeEvent evt) {
        CardLayout layout = (CardLayout) getLayout();
        layout.show(this, (String) evt.getNewValue());
    }

}
