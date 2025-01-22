package medipro.stage_menu_bar;

import java.awt.event.ActionListener;

import medipro.App;
import medipro.subjects.CardSubject;
import medipro.subjects.WorldSubject;

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
            CardSubject.setCardNumber(App.TOP_VIEW);
        };
    }

    public ActionListener handleGoToStageLevel1() {
        return e -> {
            WorldSubject.setWorld(App.worldLevel1);
            CardSubject.setCardNumber(App.GAME_VIEW);
        };
    }

    public ActionListener handleGoToStageLevel2() {
        return e -> {
            WorldSubject.setWorld(App.worldLevel2);
            CardSubject.setCardNumber(App.GAME_VIEW);
        };
    }

    public ActionListener handleGoToStageLevel3() {
        return e -> {
            WorldSubject.setWorld(App.worldLevel3);
            CardSubject.setCardNumber(App.GAME_VIEW);
        };
    }

    public ActionListener handleGoToStageLevel4() {
        return e -> {
            WorldSubject.setWorld(App.worldLevel4);
            CardSubject.setCardNumber(App.GAME_VIEW);
        };
    }

    public ActionListener handleGoToStageLevel5() {
        return e -> {
            WorldSubject.setWorld(App.worldLevel5);
            CardSubject.setCardNumber(App.GAME_VIEW);
        };
    }

    public ActionListener handleGoToStageLevel6() {
        return e -> {
            WorldSubject.setWorld(App.worldLevel6);
            CardSubject.setCardNumber(App.GAME_VIEW);
        };
    }

    public ActionListener handleGoToStageLevel7() {
        return e -> {
            WorldSubject.setWorld(App.worldLevel7);
            CardSubject.setCardNumber(App.GAME_VIEW);
        };
    }

    public ActionListener handleGoToStageLevel8() {
        return e -> {
            WorldSubject.setWorld(App.worldLevel8);
            CardSubject.setCardNumber(App.GAME_VIEW);
        };
    }

}
