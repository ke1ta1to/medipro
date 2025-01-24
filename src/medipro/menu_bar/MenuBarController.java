package medipro.menu_bar;

import medipro.App;

public class MenuBarController {

    private final MenuBarModel model;

    public MenuBarController(MenuBarModel model) {
        this.model = model;
    }

    public MenuBarModel getModel() {
        return model;
    }

    public void handleExit() {
        System.exit(0);
    }

    public void handleGoTitle() {
        App.getCardSubject().setCardNumber(App.TOP_VIEW);
    }

    public void handleChangeStage(int stageNumber) {
        App.getCardSubject().setCardNumber(App.GAME_VIEW);
        switch (stageNumber) {
            case 1:
                App.getWorldSubject().setWorld(App.worldLevel1);
                break;

            case 2:
                App.getWorldSubject().setWorld(App.worldLevel2);
                break;

            case 3:
                App.getWorldSubject().setWorld(App.worldLevel3);
                break;

            case 4:
                App.getWorldSubject().setWorld(App.worldLevel4);
                break;

            case 5:
                App.getWorldSubject().setWorld(App.worldLevel5);
                break;

            case 6:
                App.getWorldSubject().setWorld(App.worldLevel6);
                break;

            case 7:
                App.getWorldSubject().setWorld(App.worldLevel7);
                break;

            case 8:
                App.getWorldSubject().setWorld(App.worldLevel8);
                break;

            default:
                break;
        }
    }
}
