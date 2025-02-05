package net.keitaito.medipro.worlds;

import java.io.InputStream;

import net.keitaito.medipro.App;
import net.keitaito.medipro.stage.StageModel;

public class WorldLoader {

    public static World loadWorld(StageModel model, String baseDir) {
        ClassLoader classLoader = App.class.getClassLoader();
        InputStream worldTxt = classLoader
                .getResourceAsStream("net/keitaito/medipro/world_templates/" + baseDir + "/world.txt");
        InputStream exampleInputTxt = classLoader
                .getResourceAsStream("net/keitaito/medipro/world_templates/" + baseDir
                        + "/example_input.txt");
        World world = model.loadWorld(worldTxt, exampleInputTxt);
        return world;
    }

}
