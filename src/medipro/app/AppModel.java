package medipro.app;

import java.beans.PropertyChangeSupport;

public class AppModel {

    public static final String TOP_VIEW = "StartScreen";
    public static final String GAME_VIEW = "GameViewLevel1";
    public static final String LEVEL_VIEW = "levelPanel";
    public static final String SETTING_VIEW = "setting";
    public static final String HOW_TO_PLAY = "howToPlay";

    private String pageName;

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        String old = this.pageName;
        this.pageName = pageName;
        pcs.firePropertyChange("pageName", old, pageName);
    }

    public void addPropertyChangeListener(String propertyName, java.beans.PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, java.beans.PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(propertyName, listener);
    }

}
