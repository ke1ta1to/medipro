package net.keitaito.medipro.how_to_play;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HowToPlayPage1View extends JPanel {

    private final HowToPlayPage1Model model;
    private final HowToPlayPage1Controller controller;

    public HowToPlayPage1View(HowToPlayPage1Model model, HowToPlayPage1Controller controller) {
        this.model = model;
        this.controller = controller;

        JLabel titleLabel = new JLabel("testPage1", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        add(titleLabel, BorderLayout.NORTH);

    }

    public HowToPlayPage1Model getModel() {
        return model;
    }

    public HowToPlayPage1Controller getController() {
        return controller;
    }

}
