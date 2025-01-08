package medipro.app;

import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import medipro.input.InputController;
import medipro.input.InputModel;
import medipro.input.InputView;
import medipro.stage.StageController;
import medipro.stage.StageModel;
import medipro.stage.StageView;

public class AppFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public AppFrame() {
        super("medipro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel startPanel = createStartPanel();
        JPanel appViewPanel = createAppViewPanel();

        mainPanel.add(startPanel, "StartScreen");
        mainPanel.add(appViewPanel, "AppView");

        getContentPane().add(mainPanel);

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createStartPanel() {
        BorderLayout borderLayout = new BorderLayout();
        JPanel startPanel = new JPanel();
        startPanel.setLayout(borderLayout);

        JLabel gameNameLabel = new JLabel("GameName",JLabel.CENTER);

        GridLayout gridLayout = new GridLayout(3,1,10,10);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(gridLayout);

        JButton startButton = new JButton("New Game Start");
        JButton levelButton = new JButton("Level Select");
        JButton settingButton = new JButton("Setting");
        buttonPanel.add(startButton);
        buttonPanel.add(levelButton);
        buttonPanel.add(settingButton);


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "AppView");
            }
        });

        startPanel.add(gameNameLabel,BorderLayout.NORTH);
        startPanel.add(buttonPanel,BorderLayout.CENTER);
        return startPanel;
    }

    private JPanel createAppViewPanel() {
        File worldFile = new File("src/medipro/world.txt");

        StageModel stageModel = new StageModel();
        stageModel.loadWorld(worldFile);
        StageController stageController = new StageController(stageModel);
        StageView stageView = new StageView(stageModel, stageController);

        InputModel inputModel = new InputModel();
        InputController inputController = new InputController(inputModel);
        InputView inputView = new InputView(inputModel, inputController);

        AppModel appModel = new AppModel();
        AppController appController = new AppController(appModel);
        AppView appView = new AppView(appModel, appController);

        appView.setStageView(stageView);
        appView.setInputView(inputView);

        return appView;
    }

}
