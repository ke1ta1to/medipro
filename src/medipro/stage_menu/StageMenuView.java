package medipro.stage_menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class StageMenuView extends JPanel {

    private final StageMenuModel model;
    private final StageMenuController controller;

    public StageMenuView(StageMenuModel model, StageMenuController controller) {
        this.model = model;
        this.controller = controller;

        setBackground(Color.RED);
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        setPreferredSize(new Dimension(200, 200));

        // 50pxの透明なborder
        setBorder(new LineBorder(Color.WHITE, 50));
    }

    public StageMenuModel getModel() {
        return model;
    }

    public StageMenuController getController() {
        return controller;
    }

}
