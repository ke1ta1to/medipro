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
}
