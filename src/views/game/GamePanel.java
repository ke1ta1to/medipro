package views.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

    public GamePanel() {
        setBackground(Color.RED);
        setLayout(new BorderLayout());

        CommandPanel commandPanel = new CommandPanel();
        commandPanel.setPreferredSize(new Dimension(250, 0));

        StagePanel canvasPanel = new StagePanel();
        canvasPanel.setPreferredSize(new Dimension(800, 600));

        add(commandPanel, BorderLayout.WEST);
        add(canvasPanel);
    }

}
