package net.keitaito.medipro.input;

import java.beans.PropertyChangeSupport;

import javax.swing.JTextArea;
import javax.swing.text.Element;
import java.awt.FontMetrics;

import net.keitaito.medipro.App;
import net.keitaito.medipro.save.SaveData;
import net.keitaito.medipro.save.SaveManager;

public class InputModel {

    private String text;
    private Element root;
    private FontMetrics fm;
    private int lineHeight;
    private int startOffset;
    private JTextArea textArea;

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(String propertyName, java.beans.PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, java.beans.PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(propertyName, listener);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        String old = this.text;
        this.text = text;
        pcs.firePropertyChange("text", old, text);
    }

    public void loadInputText() {
        String inputText = "";
        int stageLevel = App.getLevelModel().getSelectedLevel();
        SaveData saveData = SaveManager.load();
        System.out.println("stageLevel: " + stageLevel);
        if (stageLevel == 1) {
            inputText = saveData.getWorldSaveData1().getInput();
        } else if (stageLevel == 2) {
            inputText = saveData.getWorldSaveData2().getInput();
        } else if (stageLevel == 3) {
            inputText = saveData.getWorldSaveData3().getInput();
        } else if (stageLevel == 4) {
            inputText = saveData.getWorldSaveData4().getInput();
        } else if (stageLevel == 5) {
            inputText = saveData.getWorldSaveData5().getInput();
        } else if (stageLevel == 6) {
            inputText = saveData.getWorldSaveData6().getInput();
        } else if (stageLevel == 7) {
            inputText = saveData.getWorldSaveData7().getInput();
        } else if (stageLevel == 8) {
            inputText = saveData.getWorldSaveData8().getInput();
        }
        setText(inputText);
    }

    public void setInputTextData(JTextArea textArea) {
        this.textArea = textArea;
        this.fm = textArea.getFontMetrics(this.textArea.getFont());
        this.lineHeight = this.fm.getHeight();
        this.root = this.textArea.getDocument().getDefaultRootElement();
        this.startOffset = this.textArea.getInsets().top + this.fm.getAscent();
    }

    public Element getRoot() {
        this.root = this.textArea.getDocument().getDefaultRootElement();
        return this.root;
    }

    public int getStartOffset() {
        this.startOffset = this.textArea.getInsets().top + this.fm.getAscent();
        return this.startOffset;
    }

    public int getLineHeight() {
        this.lineHeight = this.fm.getHeight();
        return this.lineHeight;
    }

    public FontMetrics getFontMetrics() {
        this.fm = this.textArea.getFontMetrics(this.textArea.getFont());
        return this.fm;
    }

    public int getStringWidth(String text) {
        return this.fm.stringWidth(text);
    }
}
