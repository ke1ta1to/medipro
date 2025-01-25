package medipro.how_to_play;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HowToPlayPage1View extends JPanel {

    public HowToPlayPage1View(HowToPlayPage1Model model, HowToPlayPage1Controller controller) {
        JLabel titleLabel = new JLabel("testPage1", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        add(titleLabel, BorderLayout.NORTH);

    }

}
