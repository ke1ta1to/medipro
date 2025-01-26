package net.keitaito.medipro.worlds;

import net.keitaito.medipro.stage.StageModel;
import net.keitaito.medipro.stage.StageView;
import net.keitaito.medipro.tiles.AirTile;
import net.keitaito.medipro.tiles.GoalTile;
import net.keitaito.medipro.tiles.RockTile;
import net.keitaito.medipro.tiles.StartTile;
import net.keitaito.medipro.tiles.ThornTile;
import net.keitaito.medipro.tiles.Tile;
import net.keitaito.medipro.tiles.WallTile;
import net.keitaito.medipro.tiles.WarpTile;

public class World {

    public static final int TILE_SIZE = 20;

    private final StageModel stageModel;

    private final String exampleCommand;

    private int startPosX;
    private int startPosY;

    private int goalPosX;
    private int goalPosY;

    private final Tile[][] tiles;

    private final WarpTile[] warpTiles = new WarpTile[2];

    public World(StageModel stageModel, String rawWorld, String exampleCommand) {
        this.stageModel = stageModel;
        this.exampleCommand = exampleCommand;

        tiles = new Tile[StageView.WIDTH / TILE_SIZE][StageView.HEIGHT / TILE_SIZE];

        String[] lines = rawWorld.split("\n");

        for (int y = 0; y < StageView.HEIGHT / TILE_SIZE; y++) {
            for (int x = 0; x < StageView.WIDTH / TILE_SIZE; x++) {
                char c = lines[y].charAt(x);
                if (c == '*') {
                    tiles[x][y] = new WallTile(x * TILE_SIZE, y * TILE_SIZE);
                } else if (c == ('R')) {
                    tiles[x][y] = new RockTile(x * TILE_SIZE, y * TILE_SIZE);
                } else if (c == ('T')) {
                    tiles[x][y] = new ThornTile(x * TILE_SIZE, y * TILE_SIZE);
                } else if (c == ('S')) {
                    tiles[x][y] = new StartTile(x * TILE_SIZE, y * TILE_SIZE);
                    startPosX = x * TILE_SIZE;
                    startPosY = y * TILE_SIZE;
                } else if (c == ('G')) {
                    tiles[x][y] = new GoalTile(x * TILE_SIZE, y * TILE_SIZE);
                    goalPosX = x * TILE_SIZE;
                    goalPosY = y * TILE_SIZE;

                } else if (c == ('W')) {
                    tiles[x][y] = new WarpTile(x * TILE_SIZE, y * TILE_SIZE);
                    if (warpTiles[0] == null) {
                        warpTiles[0] = (WarpTile) tiles[x][y];
                    } else {
                        warpTiles[1] = (WarpTile) tiles[x][y];
                    }

                } else {
                    tiles[x][y] = new AirTile(x * TILE_SIZE, y * TILE_SIZE);
                }
            }
        }
        if (warpTiles[0] != null || warpTiles[1] != null) {
            for (int i = 0; i < warpTiles.length; i++) {
                WarpTile warpTile = warpTiles[i];
                warpTile.setWarpPoint(warpTiles[(i + 1) % 2]);
            }
        }
    }

    public StageModel getStageModel() {
        return stageModel;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public int getStartPosX() {
        return startPosX;
    }

    public int getStartPosY() {
        return startPosY;
    }

    public int getGoalPosX() {
        return goalPosX;
    }

    public int getGoalPosY() {
        return goalPosY;
    }

    public WarpTile[] getWarpTiles() {
        return warpTiles;
    }

    public String getExampleCommand() {
        return exampleCommand;
    }

    public void resetState() {
        for (WarpTile warpTile : warpTiles) {
            if (warpTile != null) {
                warpTile.setIsCollided(false);
            }
        }
    }

    /**
     * 指定した座標にあるタイルを取得
     * 
     * @param posX
     * @param posY
     * @return
     */
    public Tile getTileAt(double posX, double posY) {
        int x = (int) (posX / World.TILE_SIZE);
        int y = (int) (posY / World.TILE_SIZE);
        x = Math.min(x, getTiles().length - 1);
        y = Math.min(y, getTiles()[0].length - 1);
        return getTiles()[x][y];
    }

    /**
     * 指定した座標に壁があるかどうか
     * 
     * @param posX
     * @param posY
     * @return 壁がある場合はtrue
     */
    public boolean isSolidTileAt(double posX, double posY) {
        return getTileAt(posX, posY).isSolid();
    }

}
