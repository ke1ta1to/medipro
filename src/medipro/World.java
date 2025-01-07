package medipro;

import medipro.models.StageModel;
import medipro.tiles.AirTile;
import medipro.tiles.Tile;
import medipro.tiles.WallTile;

public class World {

    public static final int TILE_SIZE = 20;

    private final StageModel stageModel;

    private final int width;
    private final int height;

    private final Tile[][] tiles;

    public World(StageModel stageModel, String rawWorld, int width, int height) {
        this.stageModel = stageModel;
        this.width = width;
        this.height = height;

        tiles = new Tile[width / TILE_SIZE][height / TILE_SIZE];

        String[] lines = rawWorld.split("\n");

        for (int y = 0; y < height / TILE_SIZE; y++) {
            for (int x = 0; x < width / TILE_SIZE; x++) {
                char c = lines[y].charAt(x);
                if (c == '*') {
                    tiles[x][y] = new WallTile(x * TILE_SIZE, y * TILE_SIZE);
                } else {
                    tiles[x][y] = new AirTile(x * TILE_SIZE, y * TILE_SIZE);
                }
            }
        }
    }

    public StageModel getStageModel() {
        return stageModel;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
