package net.keitaito.medipro.howtoplay;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HowToPlayPage2View extends JPanel {

    private final HowToPlayPage2Model model;
    private final HowToPlayPage2Controller controller;

    private final Image image;

    public HowToPlayPage2View(HowToPlayPage2Model model, HowToPlayPage2Controller controller) {
        this.model = model;
        this.controller = controller;

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(
                "net/keitaito/medipro/howtoplay/howtoplayimages/HowToPlay2.PNG"));
        image = icon.getImage().getScaledInstance(700, 400, Image.SCALE_SMOOTH);

        JLabel titleLabel = new JLabel(new ImageIcon(image), JLabel.CENTER);
        add(titleLabel, BorderLayout.NORTH);
    }

    public HowToPlayPage2Model getModel() {
        return model;
    }

    public HowToPlayPage2Controller getController() {
        return controller;
    }

}
