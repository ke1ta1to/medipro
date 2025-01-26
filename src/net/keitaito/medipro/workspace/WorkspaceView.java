package net.keitaito.medipro.workspace;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class WorkspaceView extends JPanel {

    private final WorkspaceModel model;
    private final WorkspaceController controller;

    public WorkspaceView(WorkspaceModel model, WorkspaceController controller) {
        this.model = model;
        this.controller = controller;

        BorderLayout layout = new BorderLayout();
        setLayout(layout);
    }

    public WorkspaceModel getModel() {
        return model;
    }

    public WorkspaceController getController() {
        return controller;
    }

    public void setInputView(JPanel view) {
        add(view, BorderLayout.WEST);
    }

    public void setStageView(JPanel view) {
        add(view, BorderLayout.CENTER);
    }

}
