package medipro.worlds;

import medipro.App;
import medipro.stage.StageModel;

public class WorldLoader {

    public static World loadWorld(StageModel model, String baseDir) {
        World world = model.loadWorld(
                App.class.getClassLoader().getResourceAsStream("medipro/world_templates/" + baseDir + "/world.txt"),
                App.class.getClassLoader()
                        .getResourceAsStream("medipro/world_templates/" + baseDir + "/example_input.txt"));
        return world;
    }

}
