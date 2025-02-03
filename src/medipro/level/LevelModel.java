package medipro.level;

public class LevelModel {
    private int selectedLevel;

    public int getSelectedLevel() {
        // selectedLevelがNULLの場合、0を返す
        if (selectedLevel == 0) {
            return 0;
        }
        return selectedLevel;
    }

    public void setSelectedLevel(int selectedLevel) {
        this.selectedLevel = selectedLevel;
    }
}
