package medipro.level;

public class LevelModel {
    private int selectedLevel;

    public int getSelectedLevel() {
        if (selectedLevel == 0) {
            return 0;
        }
        return selectedLevel;
    }

    public void setSelectedLevel(int selectedLevel) {
        this.selectedLevel = selectedLevel;
    }
}
