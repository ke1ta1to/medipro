package medipro.menu_bar;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarView extends JMenuBar {

    private final MenuBarModel model;
    private final MenuBarController controller;

    public MenuBarView(MenuBarModel model, MenuBarController controller) {
        this.model = model;
        this.controller = controller;

        JMenu gameMenu = new JMenu("りさプロ");

        add(gameMenu);

        JMenuItem goTitleMenu = new JMenuItem("タイトルへ戻る");
        goTitleMenu.addActionListener((e) -> {
            controller.handleGoTitle();
        });
        gameMenu.add(goTitleMenu);

        JMenuItem exitMenuItem = new JMenuItem("終了");
        exitMenuItem.addActionListener((e) -> {
            controller.handleExit();
        });
        gameMenu.add(exitMenuItem);
    }

    public MenuBarModel getModel() {
        return model;
    }

    public MenuBarController getController() {
        return controller;
    }
}
