package medipro.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;

import medipro.Entity;
import medipro.World;

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

    public StageModel() {
        entity = new Entity(this);
        ImageIcon icon = new ImageIcon(getClass().getResource("/medipro/risaju.png"));
        entity.setImage(icon.getImage());
        entity.setWidth(50);
        entity.setHeight(50);
        entity.setPosX(600);
        entity.setPosY(500);
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

    public void loadWorld(File file) {
        String text = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text += line + "\n";
            }
        } catch (Exception e) {
        }

        World world = new World(this, text, 800, 600);
        this.world = world;
    }

    public void tick() {
        // 横方向の移動
        double speed = 2;
        double velX = 0;
        if (hasKey("a")) {
            velX -= 1;
        }
        if (hasKey("d")) {
            velX += 1;
        }
        entity.setVelX(velX * speed);
        entity.setAccX(0);

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
    }

}
