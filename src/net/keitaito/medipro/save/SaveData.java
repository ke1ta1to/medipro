package net.keitaito.medipro.save;

import java.io.Serializable;

// こっちだけシリアライズする
public class SaveData implements Serializable {

    private static final long serialVersionUID = 2935853174223788090L;

    private WorldSaveData worldSaveData1;
    private WorldSaveData worldSaveData2;
    private WorldSaveData worldSaveData3;
    private WorldSaveData worldSaveData4;
    private WorldSaveData worldSaveData5;
    private WorldSaveData worldSaveData6;
    private WorldSaveData worldSaveData7;
    private WorldSaveData worldSaveData8;
    private AchievementData achievementData;

    public void destroySave() {
        worldSaveData1 = null;
        worldSaveData2 = null;
        worldSaveData3 = null;
        worldSaveData4 = null;
        worldSaveData5 = null;
        worldSaveData6 = null;
        worldSaveData7 = null;
        worldSaveData8 = null;
        achievementData = null;
    }

    public WorldSaveData getWorldSaveData1() {
        if (worldSaveData1 == null) {
            worldSaveData1 = new WorldSaveData();
        }
        return worldSaveData1;
    }

    public void setWorldSaveData1(WorldSaveData worldSaveData1) {
        this.worldSaveData1 = worldSaveData1;
    }

    public WorldSaveData getWorldSaveData2() {
        if (worldSaveData2 == null) {
            worldSaveData2 = new WorldSaveData();
        }
        return worldSaveData2;
    }

    public void setWorldSaveData2(WorldSaveData worldSaveData2) {
        this.worldSaveData2 = worldSaveData2;
    }

    public WorldSaveData getWorldSaveData3() {
        if (worldSaveData3 == null) {
            worldSaveData3 = new WorldSaveData();
        }
        return worldSaveData3;
    }

    public void setWorldSaveData3(WorldSaveData worldSaveData3) {
        this.worldSaveData3 = worldSaveData3;
    }

    public WorldSaveData getWorldSaveData4() {
        if (worldSaveData4 == null) {
            worldSaveData4 = new WorldSaveData();
        }
        return worldSaveData4;
    }

    public void setWorldSaveData4(WorldSaveData worldSaveData4) {
        this.worldSaveData4 = worldSaveData4;
    }

    public WorldSaveData getWorldSaveData5() {
        if (worldSaveData5 == null) {
            worldSaveData5 = new WorldSaveData();
        }
        return worldSaveData5;
    }

    public void setWorldSaveData5(WorldSaveData worldSaveData5) {
        this.worldSaveData5 = worldSaveData5;
    }

    public WorldSaveData getWorldSaveData6() {
        if (worldSaveData6 == null) {
            worldSaveData6 = new WorldSaveData();
        }
        return worldSaveData6;
    }

    public void setWorldSaveData6(WorldSaveData worldSaveData6) {
        this.worldSaveData6 = worldSaveData6;
    }

    public WorldSaveData getWorldSaveData7() {
        if (worldSaveData7 == null) {
            worldSaveData7 = new WorldSaveData();
        }
        return worldSaveData7;
    }

    public void setWorldSaveData7(WorldSaveData worldSaveData7) {
        this.worldSaveData7 = worldSaveData7;
    }

    public WorldSaveData getWorldSaveData8() {
        if (worldSaveData8 == null) {
            worldSaveData8 = new WorldSaveData();
        }
        return worldSaveData8;
    }

    public void setWorldSaveData8(WorldSaveData worldSaveData8) {
        this.worldSaveData8 = worldSaveData8;
    }

    public AchievementData getAchievementData() {
        if (achievementData == null) {
            achievementData = new AchievementData();
        }
        return achievementData;
    }

    public void setAchievementData(AchievementData achievementData) {
        this.achievementData = achievementData;
    }

}
