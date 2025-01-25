package medipro.how_to_play;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import medipro.observers.HowToPlaySubject;

public class HowToPlayView extends JPanel {
    private static HowToPlayView howToPlayView;

    private final HowToPlaySubject howToPlaySubject;

    public static final String NO1 = "page1";
    public static final String NO2 = "page2";

    public HowToPlayView(HowToPlayModel model, HowToPlayController controller) {

        howToPlayView = this;

        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel titleLabel = new JLabel("How To Play", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        add(titleLabel, BorderLayout.NORTH);

        JButton backButton = new JButton("前のページへ");
        backButton.setActionCommand("BACK");
        backButton.addActionListener(controller);
        add(backButton, BorderLayout.WEST);

        JButton nextButton = new JButton("次のページへ");
        nextButton.setActionCommand("NEXT");
        nextButton.addActionListener(controller);
        add(nextButton, BorderLayout.EAST);

        CardLayout cardLayout = new CardLayout();
        JPanel panel = new JPanel(cardLayout);
        howToPlaySubject = new HowToPlaySubject();
        controller.setHowToPlayView(this);
        getSubject().addObserver((howToPlayNumber) -> {
            cardLayout.show(panel, howToPlayNumber);
        });
        JPanel page1 = new HowToPlayPage1View(new HowToPlayPage1Model(), new HowToPlayPage1Controller());
        JPanel page2 = new HowToPlayPage2View(new HowToPlayPage2Model(), new HowToPlayPage2Controller());
        panel.add(page1, howToPlayView.NO1);
        panel.add(page2, howToPlayView.NO2);

        add(panel, BorderLayout.CENTER);

        JPanel exitPanel = new JPanel(new GridLayout(1, 1, 15, 30));
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 20));
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(controller);
        exitPanel.add(exitButton);
        add(exitPanel, BorderLayout.SOUTH);
    }

    public static HowToPlaySubject getSubject() {
        HowToPlaySubject howToPlaySubject = howToPlayView.howToPlaySubject;
        if (howToPlaySubject == null) {
            throw new IllegalStateException("cardSubject is null");
        }
        return howToPlaySubject;
    }
}
