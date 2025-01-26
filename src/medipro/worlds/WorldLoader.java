package medipro.worlds;

import medipro.App;
import medipro.stage.StageModel;

public class WorldLoader {

    public static World loadWorld(StageModel model, String basePath) {
        World world = model.loadWorld(
                App.class.getClassLoader().getResourceAsStream("medipro/world_templates/" + basePath + ".txt"),
                App.class.getClassLoader()
                        .getResourceAsStream("medipro/world_templates/" + basePath + "_example_command.txt"));
        return world;
    }
}
