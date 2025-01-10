package medipro.app;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class AppFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private AppController appController;

    public AppFrame() {
        super("medipro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        AppModel appModel = new AppModel();
        appController = new AppController(appModel, cardLayout, mainPanel);

        StartPanel startPanel = new StartPanel(appController);
        GamePanel gamePanel = new GamePanel(appController);

        mainPanel.add(startPanel, "StartScreen");
        mainPanel.add(gamePanel, "AppView");

        getContentPane().add(mainPanel);

        pack();
        setLocationRelativeTo(null);
    }
}
