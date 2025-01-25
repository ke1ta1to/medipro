package medipro.how_to_play;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HowToPlayPage2View extends JPanel {
    public HowToPlayPage2View(HowToPlayPage2Model model, HowToPlayPage2Controller controller) {
        JLabel titleLabel = new JLabel("testPage2", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        add(titleLabel, BorderLayout.NORTH);
    }

}
