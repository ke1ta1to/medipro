package net.keitaito.medipro.gameclear;

import java.beans.PropertyChangeSupport;

public class GameClearModel {
    private boolean open = false;

    private boolean registered = false;

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(String propertyName, java.beans.PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, java.beans.PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(propertyName, listener);
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        boolean old = this.open;
        this.open = open;
        pcs.firePropertyChange("open", old, open);
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        boolean old = this.registered;
        this.registered = registered;
        pcs.firePropertyChange("registered", old, registered);
    }
}
