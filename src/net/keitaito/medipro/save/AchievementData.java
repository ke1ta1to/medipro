package net.keitaito.medipro.save;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AchievementData implements Serializable {

    private static final long serialVersionUID = 3811643340731509827L;

    public static List<String> ALL_ACHIEVEMENTS = List.of("Hello World", "All Clear", "Not Use Jump", "Code Max 8");
    private List<String> checkedAchivements = new ArrayList<>();

    public List<String> getCheckedAchivements() {
        return checkedAchivements;
    }

    public void addCheckedAchivement(String achivement) {
        checkedAchivements.add(achivement);
    }

    public void removeCheckedAchivement(String achivement) {
        checkedAchivements.remove(achivement);
    }

    public void clearCheckedAchivements() {
        checkedAchivements.clear();
    }

    public boolean checkAchivement(String achivement) {
        return checkedAchivements.contains(achivement);
    }

}
