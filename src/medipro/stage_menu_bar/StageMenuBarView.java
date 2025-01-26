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
        goToTopButton.addActionListener(controller::handleGoToTop);
        add(goToTopButton);

        JButton goToStageLevel1Button = new JButton("Go Level 1");
        goToStageLevel1Button.addActionListener(controller::handleGoToStageLevel1);
        add(goToStageLevel1Button);

        JButton goToStageLevel2Button = new JButton("Go Level 2");
        goToStageLevel2Button.addActionListener(controller::handleGoToStageLevel2);
        add(goToStageLevel2Button);

        JButton goToStageLevel3Button = new JButton("Go Level 3");
        goToStageLevel3Button.addActionListener(controller::handleGoToStageLevel3);
        add(goToStageLevel3Button);

        JButton goToStageLevel4Button = new JButton("Go Level 4");
        goToStageLevel4Button.addActionListener(controller::handleGoToStageLevel4);
        add(goToStageLevel4Button);

        JButton goToStageLevel5Button = new JButton("Go Level 5");
        goToStageLevel5Button.addActionListener(controller::handleGoToStageLevel5);
        add(goToStageLevel5Button);

        JButton goToStageLevel6Button = new JButton("Go Level 6");
        goToStageLevel6Button.addActionListener(controller::handleGoToStageLevel6);
        add(goToStageLevel6Button);

        JButton goToStageLevel7Button = new JButton("Go Level 7");
        goToStageLevel7Button.addActionListener(controller::handleGoToStageLevel7);
        add(goToStageLevel7Button);

        JButton goToStageLevel8Button = new JButton("Go Level 8");
        goToStageLevel8Button.addActionListener(controller::handleGoToStageLevel8);
        add(goToStageLevel8Button);
    }

    public StageMenuBarModel getModel() {
        return model;
    }

    public StageMenuBarController getController() {
        return controller;
    }

}
