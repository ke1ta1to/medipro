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
        add(gameMenu);

        JMenu debugMenu = new JMenu("デバッグ");
        JMenu changeStageMenu = new JMenu("ステージ変更");
        for (int i = 1; i <= 8; i++) {
            JMenuItem changeStageMenuItem = new JMenuItem("ステージ" + i);
            int stageNumber = i;
            changeStageMenuItem.addActionListener((e) -> {
                controller.handleChangeStage(stageNumber);
            });
            changeStageMenu.add(changeStageMenuItem);
        }
        debugMenu.add(changeStageMenu);
        add(debugMenu);
    }

    public MenuBarModel getModel() {
        return model;
    }

    public MenuBarController getController() {
        return controller;
    }
}
