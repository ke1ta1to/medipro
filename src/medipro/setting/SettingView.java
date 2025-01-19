package medipro.setting;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingView extends JPanel {
    public SettingView(SettingModel model, SettingController controller) {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel titleLabel = new JLabel("Setting", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        add(titleLabel, BorderLayout.NORTH);
        // TODO: 設定画面の詳細の作成

        JPanel exitPanel = new JPanel(new GridLayout(1, 1, 15, 30));
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 20));
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(controller);
        exitPanel.add(exitButton);
        add(exitPanel, BorderLayout.SOUTH);
    }
}
