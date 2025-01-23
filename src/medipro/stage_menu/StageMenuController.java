package medipro.stage_menu;

public class StageMenuController {

    private final StageMenuModel model;

    public StageMenuController(StageMenuModel model) {
        this.model = model;
    }

    public StageMenuModel getModel() {
        return model;
    }

    public void handleClose() {
        if (model.getOnClose() != null) {
            model.getOnClose().run();
        }
    }

}
