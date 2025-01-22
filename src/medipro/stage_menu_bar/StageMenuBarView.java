package medipro.stage_menu_bar;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StageMenuBarView extends JPanel {

    private final StageMenuBarModel model;
    private final StageMenuBarController controller;

    public StageMenuBarView(StageMenuBarModel model, StageMenuBarController controller) {
        this.model = model;
        this.controller = controller;

        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        setLayout(layout);

        JButton goToTopButton = new JButton("Go to Top");
        goToTopButton.addActionListener(controller.handleGoToTop());
        add(goToTopButton);

        JButton goToStageLevel1Button = new JButton("Go to Stage Level 1");
        goToStageLevel1Button.addActionListener(controller.handleGoToStageLevel1());
        add(goToStageLevel1Button);

        JButton goToStageLevel2Button = new JButton("Go to Stage Level 2");
        goToStageLevel2Button.addActionListener(controller.handleGoToStageLevel2());
        add(goToStageLevel2Button);

        JButton goToStageLevel3Button = new JButton("Go to Stage Level 3");
        goToStageLevel3Button.addActionListener(controller.handleGoToStageLevel3());
        add(goToStageLevel3Button);
    }

    public StageMenuBarModel getModel() {
        return model;
    }

    public StageMenuBarController getController() {
        return controller;
    }

}
