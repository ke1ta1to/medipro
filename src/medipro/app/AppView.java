package medipro.app;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class AppView extends JPanel {

    private final AppModel model;
    private final AppController controller;

    private JPanel parentView;

    public AppView(AppModel model, AppController controller) {
        this.model = model;
        this.controller = controller;

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        // parentView = new JPanel(new CardLayout());
        // add(parentView, BorderLayout.CENTER);
    }

    public void setStageView(JPanel view) {
        add(view, BorderLayout.CENTER);
    }

    public void setInputView(JPanel view) {
        add(view, BorderLayout.WEST);
    }

    public void setStageMenuBarView(JPanel view) {
        add(view, BorderLayout.NORTH);
    }

    public AppModel getModel() {
        return model;
    }

    public AppController getController() {
        return controller;
    }

}
