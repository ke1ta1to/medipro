package medipro.menu_bar;

import medipro.App;
import medipro.level.LevelModel;

public class MenuBarController {

    private final MenuBarModel model;
    private final LevelModel levelModel;

    public MenuBarController(MenuBarModel model, LevelModel levelModel) {
        this.model = model;
        this.levelModel = levelModel;
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
                levelModel.setSelectedLevel(1);
                break;

            case 2:
                App.getWorldSubject().setWorld(App.worldLevel2);
                levelModel.setSelectedLevel(2);
                break;

            case 3:
                App.getWorldSubject().setWorld(App.worldLevel3);
                levelModel.setSelectedLevel(3);
                break;

            case 4:
                App.getWorldSubject().setWorld(App.worldLevel4);
                levelModel.setSelectedLevel(4);
                break;

            case 5:
                App.getWorldSubject().setWorld(App.worldLevel5);
                levelModel.setSelectedLevel(5);
                break;

            case 6:
                App.getWorldSubject().setWorld(App.worldLevel6);
                levelModel.setSelectedLevel(6);
                break;

            case 7:
                App.getWorldSubject().setWorld(App.worldLevel7);
                levelModel.setSelectedLevel(7);
                break;

            case 8:
                App.getWorldSubject().setWorld(App.worldLevel8);
                levelModel.setSelectedLevel(8);
                break;

            default:
                break;
        }
    }
}
