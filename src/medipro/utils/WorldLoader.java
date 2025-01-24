package medipro.utils;

import medipro.App;
import medipro.World;
import medipro.stage.StageModel;

public class WorldLoader {

    public static World loadWorld(StageModel model, String basePath) {
        World world = model.loadWorld(
                App.class.getClassLoader().getResourceAsStream("medipro/worlds/" + basePath + ".txt"),
                App.class.getClassLoader().getResourceAsStream("medipro/worlds/" + basePath + "_example_command.txt"));
        return world;
    }
}
