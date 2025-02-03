package net.keitaito.medipro.howtoplay;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HowToPlayView extends JPanel {

    private final JPanel parent;

    public HowToPlayView(HowToPlayModel model, HowToPlayController controller) {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel titleLabel = new JLabel("How To Play", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        add(titleLabel, BorderLayout.NORTH);

        CardLayout cardLayout = new CardLayout();
        parent = new JPanel(cardLayout);
        add(parent, BorderLayout.CENTER);

        JButton backButton = new JButton("前のページへ");
        backButton.addActionListener(controller::handleClickBackButton);
        add(backButton, BorderLayout.WEST);

        JButton nextButton = new JButton("次のページへ");
        nextButton.addActionListener(controller::handleClickNextButton);
        add(nextButton, BorderLayout.EAST);

        JPanel exitPanel = new JPanel(new GridLayout(1, 1, 15, 30));
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 20));
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(controller::handleClickExitButton);
        exitPanel.add(exitButton);
        add(exitPanel, BorderLayout.SOUTH);

        model.addPropertyChangeListener("currentPage", this::updatePage);
    }

    public void addPage(JPanel page, String name) {
        parent.add(page, name);
    }

    private void updatePage(PropertyChangeEvent evt) {
        CardLayout cardLayout = (CardLayout) parent.getLayout();
        cardLayout.show(parent, (String) evt.getNewValue());
    }

}
