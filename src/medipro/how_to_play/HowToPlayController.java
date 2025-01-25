package medipro.how_to_play;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import medipro.App;

public class HowToPlayController implements ActionListener {
    private final HowToPlayModel model;
    private HowToPlayView view;

    public HowToPlayController(HowToPlayModel model) {
        this.model = model;
    }

    public HowToPlayModel getModel() {
        return model;
    }

    public void setHowToPlayView(HowToPlayView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "exit":
                App.getCardSubject().setCardNumber(App.TOP_VIEW);
                break;
            case "BACK":
                view.setCurrent(view.getCurrent() - 1);
                HowToPlayView.getSubject().setHowToPlayNumber(view.getPages(view.getPAGES(), view.getCurrent()));
                break;
            case "NEXT":
                view.setCurrent(view.getCurrent() + 1);
                HowToPlayView.getSubject().setHowToPlayNumber(view.getPages(view.getPAGES(), view.getCurrent()));
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
