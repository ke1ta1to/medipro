package net.keitaito.medipro.save;

import java.io.Serializable;

public class WorldSaveData implements Serializable {

    private static final long serialVersionUID = 3485623L;
    private boolean cleared;
    private String ansCommand;

    public boolean isCleared() {
        return cleared;
    }

    public void setCleared(boolean cleared) {
        this.cleared = cleared;
    }

    public String getAnsCommand() {
        return ansCommand;
    }

    public void setAnsCommand(String ansCommand) {
        this.ansCommand = ansCommand;
    }

}
