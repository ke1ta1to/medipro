package net.keitaito.medipro.app;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AppFrame extends JFrame {

    public AppFrame() {
        super("medipro");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // フレームのアイコンを設定
        ImageIcon icon = new ImageIcon(
                getClass().getClassLoader().getResource("net/keitaito/medipro/images/risaju.png"));
        setIconImage(icon.getImage());

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

}
