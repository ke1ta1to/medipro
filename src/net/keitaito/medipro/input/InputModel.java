package net.keitaito.medipro.input;

import java.beans.PropertyChangeSupport;

public class InputModel {

    private String text;

    private boolean openedMenu = false;

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(String propertyName, java.beans.PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, java.beans.PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(propertyName, listener);
    }

    public void setOpenedMenu(boolean isOpenMenu) {
        boolean oldIsOpenMenu = this.openedMenu;
        this.openedMenu = isOpenMenu;
        pcs.firePropertyChange("openedMenu", oldIsOpenMenu, isOpenMenu);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        String old = this.text;
        this.text = text;
        pcs.firePropertyChange("text", old, text);
    }

}
