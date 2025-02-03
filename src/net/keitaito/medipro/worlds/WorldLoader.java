package net.keitaito.medipro.worlds;

import java.io.InputStream;
import java.net.URL;

import net.keitaito.medipro.App;
import net.keitaito.medipro.stage.StageModel;

public class WorldLoader {

    public static World loadWorld(StageModel model, String baseDir) {
        ClassLoader classLoader = App.class.getClassLoader();
        InputStream worldTxt = classLoader
                .getResourceAsStream("net/keitaito/medipro/world_templates/" + baseDir + "/world.txt");
        // TODO: 最終的にここはSave_textから引っ張ってくる。
        InputStream exampleInputTxt = classLoader
                .getResourceAsStream("net/keitaito/medipro/world_templates/" + baseDir
                        + "/example_input.txt");
        URL thumbnailUrl = classLoader
                .getResource("net/keitaito/medipro/world_templates/" + baseDir + "/thumbnail.png");
        World world = model.loadWorld(worldTxt, exampleInputTxt, thumbnailUrl);
        return world;
    }

}
