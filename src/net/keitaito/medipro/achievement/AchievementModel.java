package net.keitaito.medipro.achievement;

import java.io.IOException;

import net.keitaito.medipro.save.SaveData;
import net.keitaito.medipro.save.SaveManager;

public class AchievementModel {
    SaveData saveData = SaveManager.load();
    private boolean isHelloWorld = saveData.getAchievementData().isHelloWorld();
    private boolean isAllClear = saveData.getAchievementData().isHelloWorld();
    private boolean isNotUseJump = saveData.getAchievementData().isHelloWorld();
    private boolean isCodeMax8 = saveData.getAchievementData().isHelloWorld();

    public boolean isHelloWorld() {
        return isHelloWorld;
    }

    public void setHelloWorld(boolean helloWorld) {
        isHelloWorld = helloWorld;
    }

    public boolean isAllClear() {
        return isAllClear;
    }

    public void setAllClear(boolean allClear) {
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

    public void checkHelloWorld() {
        if (saveData.getWorldSaveData1().isChecked()) {
            isHelloWorld = true;
            saveData.getAchievementData().setHelloWorld(true);
            try {
                SaveManager.save(saveData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkAllClear() {
        if (saveData.getWorldSaveData1().isChecked() && saveData.getWorldSaveData2().isChecked()
                && saveData.getWorldSaveData3().isChecked() && saveData.getWorldSaveData4().isChecked()
                && saveData.getWorldSaveData5().isChecked() && saveData.getWorldSaveData6().isChecked()
                && saveData.getWorldSaveData7().isChecked() && saveData.getWorldSaveData8().isChecked()) {
            isAllClear = true;
            saveData.getAchievementData().setAllClear(true);
            try {
                SaveManager.save(saveData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkNotUseJump() {
        String stage1 = saveData.getWorldSaveData1().getInput();
        String stage2 = saveData.getWorldSaveData2().getInput();
        String stage3 = saveData.getWorldSaveData3().getInput();
        String stage4 = saveData.getWorldSaveData4().getInput();
        String stage5 = saveData.getWorldSaveData5().getInput();
        String stage6 = saveData.getWorldSaveData6().getInput();
        String stage7 = saveData.getWorldSaveData7().getInput();
        String stage8 = saveData.getWorldSaveData8().getInput();
        if ((saveData.getWorldSaveData1().isChecked() && saveData.getWorldSaveData2().isChecked()
                && saveData.getWorldSaveData3().isChecked() && saveData.getWorldSaveData4().isChecked()
                && saveData.getWorldSaveData5().isChecked() && saveData.getWorldSaveData6().isChecked()
                && saveData.getWorldSaveData7().isChecked() && saveData.getWorldSaveData8().isChecked())
                && !stage1.contains("jump") && !stage2.contains("jump") && !stage3.contains("jump")
                && !stage4.contains("jump")
                && !stage5.contains("jump") && !stage6.contains("jump") && !stage7.contains("jump")
                && !stage8.contains("jump")) {
            isNotUseJump = true;
            saveData.getAchievementData().setNotUseJump(true);
            try {
                SaveManager.save(saveData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkCodeMax8() {
        String stage1 = saveData.getWorldSaveData1().getInput();
        String stage2 = saveData.getWorldSaveData2().getInput();
        String stage3 = saveData.getWorldSaveData3().getInput();
        String stage4 = saveData.getWorldSaveData4().getInput();
        String stage5 = saveData.getWorldSaveData5().getInput();
        String stage6 = saveData.getWorldSaveData6().getInput();
        String stage7 = saveData.getWorldSaveData7().getInput();
        String stage8 = saveData.getWorldSaveData8().getInput();
        if ((saveData.getWorldSaveData1().isChecked() && saveData.getWorldSaveData2().isChecked()
                && saveData.getWorldSaveData3().isChecked() && saveData.getWorldSaveData4().isChecked()
                && saveData.getWorldSaveData5().isChecked() && saveData.getWorldSaveData6().isChecked()
                && saveData.getWorldSaveData7().isChecked() && saveData.getWorldSaveData8().isChecked())
                && countNewLines(stage1) <= 8 && countNewLines(stage2) <= 8 && countNewLines(stage3) <= 8
                && countNewLines(stage4) <= 8 && countNewLines(stage5) <= 8 && countNewLines(stage6) <= 8
                && countNewLines(stage7) <= 8 && countNewLines(stage8) <= 8) {
            isCodeMax8 = true;
            saveData.getAchievementData().setCodeMax8(true);
            try {
                SaveManager.save(saveData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkAll() {
        checkHelloWorld();
        checkAllClear();
        checkNotUseJump();
        checkCodeMax8();
    }

    private int countNewLines(String input) {
        return input.length() - input.replace("\n", "").length();
    }
}
