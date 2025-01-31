package net.keitaito.medipro.input_command_menu;

import java.beans.PropertyChangeSupport;

public class InputCommandMenuModel {
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private String page;

    public InputCommandMenuModel() {

    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        String old = this.page;
        this.page = page;
        pcs.firePropertyChange("page", old, page);
    }

    public void addPropertyChangeListener(String propertyName, java.beans.PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, java.beans.PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(propertyName, listener);
    }

}
