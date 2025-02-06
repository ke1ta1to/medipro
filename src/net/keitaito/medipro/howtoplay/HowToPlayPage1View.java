package net.keitaito.medipro.howtoplay;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HowToPlayPage1View extends JPanel {

    private final HowToPlayPage1Model model;
    private final HowToPlayPage1Controller controller;
    private Image image;

    public HowToPlayPage1View(HowToPlayPage1Model model, HowToPlayPage1Controller controller) {
        this.model = model;
        this.controller = controller;

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(
                "net/keitaito/medipro/howtoplay/howtoplayimages/HowToPlay1.PNG"));
        image = icon.getImage().getScaledInstance(700, 400, Image.SCALE_SMOOTH);

        JLabel titleLabel = new JLabel(new ImageIcon(image), JLabel.CENTER);
        add(titleLabel, BorderLayout.NORTH);

    }

    public HowToPlayPage1Model getModel() {
        return model;
    }

    public HowToPlayPage1Controller getController() {
        return controller;
    }

}
