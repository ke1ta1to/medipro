package net.keitaito.medipro.app;

import java.beans.PropertyChangeSupport;

public class AppModel {

    public static final String PAGE_TITLE = "title";
    public static final String PAGE_WORKSPACE = "workspace";
    public static final String PAGE_LEVEL_SELECT = "level-select";
    public static final String PAGE_SETTING = "setting";
    public static final String PAGE_HOW_TO_PLAY = "how-to-play";

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
