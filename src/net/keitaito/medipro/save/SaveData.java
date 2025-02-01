package net.keitaito.medipro.save;

import java.io.Serializable;

//こっちだけシリアライズする
public class SaveData implements Serializable {
    private static final long serialVersionUID = 3485623L;
    private WorldSaveData worldSaveData1;
    private WorldSaveData worldSaveData2;
    private WorldSaveData worldSaveData3;
    private WorldSaveData worldSaveData4;
    private WorldSaveData worldSaveData5;
    private WorldSaveData worldSaveData6;
    private WorldSaveData worldSaveData7;
    private WorldSaveData worldSaveData8;

    public WorldSaveData getWorldSaveData1() {
        return worldSaveData1;
    }

    public void setWorldSaveData1(WorldSaveData worldSaveData1) {
        this.worldSaveData1 = worldSaveData1;
    }

    public WorldSaveData getWorldSaveData2() {
        return worldSaveData2;
    }

    public void setWorldSaveData2(WorldSaveData worldSaveData2) {
        this.worldSaveData2 = worldSaveData2;
    }

    public WorldSaveData getWorldSaveData3() {
        return worldSaveData3;
    }

    public void setWorldSaveData3(WorldSaveData worldSaveData3) {
        this.worldSaveData3 = worldSaveData3;
    }

    public WorldSaveData getWorldSaveData4() {
        return worldSaveData4;
    }

    public void setWorldSaveData4(WorldSaveData worldSaveData4) {
        this.worldSaveData4 = worldSaveData4;
    }

    public WorldSaveData getWorldSaveData5() {
        return worldSaveData5;
    }

    public void setWorldSaveData5(WorldSaveData worldSaveData5) {
        this.worldSaveData5 = worldSaveData5;
    }

    public WorldSaveData getWorldSaveData6() {
        return worldSaveData6;
    }

    public void setWorldSaveData6(WorldSaveData worldSaveData6) {
        this.worldSaveData6 = worldSaveData6;
    }

    public WorldSaveData getWorldSaveData7() {
        return worldSaveData7;
    }

    public void setWorldSaveData7(WorldSaveData worldSaveData7) {
        this.worldSaveData7 = worldSaveData7;
    }

    public WorldSaveData getWorldSaveData8() {
        return worldSaveData8;
    }

    public void setWorldSaveData8(WorldSaveData worldSaveData8) {
        this.worldSaveData8 = worldSaveData8;
    }

}
