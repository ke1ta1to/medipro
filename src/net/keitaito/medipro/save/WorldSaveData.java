package net.keitaito.medipro.save;

import java.io.Serializable;

public class WorldSaveData implements Serializable {

    private static final long serialVersionUID = 3811643340731509827L;

    private boolean checked;
    private String input = "";

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String ansCommand) {
        this.input = ansCommand;
    }

}
