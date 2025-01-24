package medipro;

import java.io.Serializable;
import java.util.Map;

public class WorldTemplate implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final Map<Character, Short> tileMap = Map.of(
            '*', (short) 1,
            'R', (short) 2,
            'T', (short) 3,
            'S', (short) 4,
            'G', (short) 5,
            'W', (short) 6);

    private final String name;
    private final String author;
    private final int height;
    private final int width;
    private final String initialCommand;
    private final short[][] tileIDs;

    public WorldTemplate(String rawWorld, int width, int height, String initialCommand) {
        this.name = "World";
        this.author = "Unknown";
        this.height = height;
        this.width = width;
        this.initialCommand = initialCommand;
        this.tileIDs = new short[width][height];

        String[] lines = rawWorld.split("\n");
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                char c = lines[y].charAt(x);
                tileIDs[x][y] = tileMap.get(c);
            }
        }
    }

    public static Map<Character, Short> getTilemap() {
        return tileMap;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getInitialCommand() {
        return initialCommand;
    }

    public short[][] getTileIDs() {
        return tileIDs;
    }
}
