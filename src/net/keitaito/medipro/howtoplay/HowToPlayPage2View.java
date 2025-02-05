package net.keitaito.medipro.howtoplay;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HowToPlayPage2View extends JPanel {

    private final HowToPlayPage2Model model;
    private final HowToPlayPage2Controller controller;

    public HowToPlayPage2View(HowToPlayPage2Model model, HowToPlayPage2Controller controller) {
        this.model = model;
        this.controller = controller;

        JLabel titleLabel = new JLabel("testPage2", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        add(titleLabel, BorderLayout.NORTH);
    }

    public HowToPlayPage2Model getModel() {
        return model;
    }

    public HowToPlayPage2Controller getController() {
        return controller;
    }

}
