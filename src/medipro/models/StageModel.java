package medipro.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import medipro.Entity;

public class StageModel {

    /**
     * 有効キー: a, d, スペース
     */
    private final List<String> availableKeys = List.of("a", "d", " ");
    private Set<String> keys = new HashSet<>();
    private Entity entity = new Entity();

    // 重力の考慮
    private double gravity = .2;

    // ジャンプ力
    private double jumpPower = -5;

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
        if (hasKey(" ") && entity.getPosY() == 100) {
            accY = jumpPower;
        }
        entity.setAccY(accY);

        // 速度を加速度に加算
        entity.setVelX(entity.getVelX() + entity.getAccX());
        entity.setVelY(entity.getVelY() + entity.getAccY());

        // 位置を速度に加算、ただし床はy200（キャラクターの高さ100）
        entity.setPosX(entity.getPosX() + entity.getVelX());
        entity.setPosY(Math.min(100, entity.getPosY() + entity.getVelY()));
    }

}
