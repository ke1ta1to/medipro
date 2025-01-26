package net.keitaito.medipro.worlds;

import net.keitaito.medipro.App;
import net.keitaito.medipro.stage.StageModel;

public class WorldLoader {

    public static World loadWorld(StageModel model, String baseDir) {
        World world = model.loadWorld(
                App.class.getClassLoader().getResourceAsStream("medipro/world_templates/" + baseDir + "/world.txt"),
                App.class.getClassLoader()
                        .getResourceAsStream("medipro/world_templates/" + baseDir + "/example_input.txt"));
        return world;
    }

}
