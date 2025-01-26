package medipro.stage_menu_bar;

import java.awt.event.ActionListener;

import medipro.App;

public class StageMenuBarController {

    private final StageMenuBarModel model;

    public StageMenuBarController(StageMenuBarModel model) {
        this.model = model;
    }

    public StageMenuBarModel getModel() {
        return model;
    }

    public ActionListener handleGoToTop() {
        return e -> {
            App.getCardSubject().setCardNumber(App.TOP_VIEW);
        };
    }

    public ActionListener handleGoToStageLevel1() {
        return e -> {
            App.getStageModel().setWorld(App.worldLevel1);
            App.getCardSubject().setCardNumber(App.GAME_VIEW);
        };
    }

    public ActionListener handleGoToStageLevel2() {
        return e -> {
            App.getStageModel().setWorld(App.worldLevel2);
            App.getCardSubject().setCardNumber(App.GAME_VIEW);
        };
    }

    public ActionListener handleGoToStageLevel3() {
        return e -> {
            App.getStageModel().setWorld(App.worldLevel3);
            App.getCardSubject().setCardNumber(App.GAME_VIEW);
        };
    }

    public ActionListener handleGoToStageLevel4() {
        return e -> {
            App.getStageModel().setWorld(App.worldLevel4);
            App.getCardSubject().setCardNumber(App.GAME_VIEW);
        };
    }

    public ActionListener handleGoToStageLevel5() {
        return e -> {
            App.getStageModel().setWorld(App.worldLevel5);
            App.getCardSubject().setCardNumber(App.GAME_VIEW);
        };
    }

    public ActionListener handleGoToStageLevel6() {
        return e -> {
            App.getStageModel().setWorld(App.worldLevel6);
            App.getCardSubject().setCardNumber(App.GAME_VIEW);
        };
    }

    public ActionListener handleGoToStageLevel7() {
        return e -> {
            App.getStageModel().setWorld(App.worldLevel7);
            App.getCardSubject().setCardNumber(App.GAME_VIEW);
        };
    }

    public ActionListener handleGoToStageLevel8() {
        return e -> {
            App.getStageModel().setWorld(App.worldLevel8);
            App.getCardSubject().setCardNumber(App.GAME_VIEW);
        };
    }

}
