package net.keitaito.medipro.save;

import java.io.Serializable;

public class AchievementData implements Serializable {

    private static final long serialVersionUID = 3811643340731509827L;

    private boolean isHelloWorld;
    private boolean isAllClear;
    private boolean isNotUseJump;
    private boolean isCodeMax8;

    public AchievementData() {
        isHelloWorld = false;
        isAllClear = false;
        isNotUseJump = false;
        isCodeMax8 = false;
    }

    public boolean isHelloWorld() {
        if (isHelloWorld) {
            return false;
        }
        return isHelloWorld;
    }

    public void setHelloWorld(boolean helloWorld) {
        if (helloWorld) {
            isHelloWorld = false;
        }
        isHelloWorld = helloWorld;
    }

    public boolean isAllClear() {
        if (isAllClear) {
            return false;
        }
        return isAllClear;
    }

    public void setAllClear(boolean allClear) {
        if (allClear) {
            isAllClear = false;
        }
        isAllClear = allClear;
    }

    public boolean isNotUseJump() {
        return isNotUseJump;
    }

    public void setNotUseJump(boolean notUseJump) {
        isNotUseJump = notUseJump;
    }

    public boolean isCodeMax8() {
        return isCodeMax8;
    }

    public void setCodeMax8(boolean codeMax8) {
        isCodeMax8 = codeMax8;
    }

}
