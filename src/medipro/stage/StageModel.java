package medipro.stage;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;

import medipro.Entity;
import medipro.World;
import medipro.subjects.WorldSubject;

public class StageModel {

    private World world = null;

    /**
     * 有効キー: a, d, スペース
     */
    private final List<String> availableKeys = List.of("a", "d", " ");
    private Set<String> keys = new HashSet<>();
    private Entity entity;

    // 重力の考慮
    private double gravity = 0.2;

    // ジャンプ力
    private double jumpPower = -6.5;

    private final Image characterLeftWalk0 = loadImage("L_walk_0.png");
    private final Image characterLeftWalk1 = loadImage("L_walk_1.png");
    private final Image characterLeftWalk2 = loadImage("L_walk_2.png");
    private final Image characterLeftWalkHat0 = loadImage("L_walk_hat_0.png");
    private final Image characterLeftWalkHat1 = loadImage("L_walk_hat_1.png");
    private final Image characterLeftWalkHat2 = loadImage("L_walk_hat_2.png");
    private final Image characterRightWalk0 = loadImage("R_walk_0.png");
    private final Image characterRightWalk1 = loadImage("R_walk_1.png");
    private final Image characterRightWalk2 = loadImage("R_walk_2.png");
    private final Image characterRightWalkHat0 = loadImage("R_walk_hat_0.png");
    private final Image characterRightWalkHat1 = loadImage("R_walk_hat_1.png");
    private final Image characterRightWalkHat2 = loadImage("R_walk_hat_2.png");

    public StageModel() {
        entity = new Entity(this);
        Image image = characterRightWalk0;
        entity.setImage(image);
        entity.setWidth(50);
        entity.setHeight(50);
        entity.setPosX(600);
        entity.setPosY(500);

        WorldSubject.addObserver(() -> {
            world = WorldSubject.getWorld();
        });
    }

    public void addKey(String key) {
        if (availableKeys.contains(key)) {
            keys.add(key);
        }
    }

    public void removeKey(String key) {
        keys.remove(key);
    }

    public boolean hasKey(String key) {
        return keys.contains(key);
    }

    public Set<String> getKeys() {
        return keys;
    }

    public Entity getEntity() {
        return entity;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public World loadWorld(File file) {
        String text = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text += line + "\n";
            }
        } catch (Exception e) {
        }

        World world = new World(this, text, 800, 600);
        return world;
    }

    public void tick() {
        // 横方向の移動
        double speed = 0.2;
        double accX = 0;
        if (entity.isOnGround()) {
            if (hasKey("a")) {
                accX -= 1;
            }
            if (hasKey("d")) {
                accX += 1;
            }
        } else {
            if (hasKey("a")) {
                accX -= 0.5;
            }
            if (hasKey("d")) {
                accX += 0.5;
            }
        }

        entity.setAccX(accX * speed);

        // 重力とジャンプ
        double accY = gravity; // 最終的な加速度
        if (hasKey(" ")) {
            // 下がタイルに接している場合ジャンプ
            if (entity.isOnGround()) {
                accY = jumpPower;
            }
        }
        entity.setAccY(accY);

        // 速度を加速度に加算
        entity.setVelX(entity.getVelX() + entity.getAccX());
        entity.setVelY(entity.getVelY() + entity.getAccY());

        // 位置を速度に加算
        entity.setPosX(entity.getPosX() + entity.getVelX());
        entity.setPosY(entity.getPosY() + entity.getVelY());

        // 速度を見て、キャラクターの画像を変更する
        if (entity.getVelX() > 0) {
            if (!entity.isOnGround() || (entity.getVelX() < 0.5)) {
                entity.setImage(characterRightWalkHat0);
            } else {
                if (entity.getVelX() % 2 < 1) {
                    entity.setImage(characterRightWalkHat1);
                } else {
                    entity.setImage(characterRightWalkHat2);
                }
            }
        } else {
            if (!entity.isOnGround() || (entity.getVelX() > -0.5)) {
                entity.setImage(characterLeftWalkHat0);
            } else {
                if (entity.getVelX() % 2 > -1) {
                    entity.setImage(characterLeftWalkHat1);
                } else {
                    entity.setImage(characterLeftWalkHat2);
                }
            }
        }
    }

    private Image loadImage(String name) {
        return new ImageIcon(getClass().getResource(
                "/medipro/images/" + name)).getImage();
    }
}
