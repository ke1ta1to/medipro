package medipro.tiles;

import java.awt.Graphics;

import medipro.App;
import medipro.Entity;

public class GoalDummyTile extends AirTile {

    public GoalDummyTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g, int stageLevel) {

    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public void onCollide(Entity target) {
        // TODO: ゴールした際の処理
        System.out.println("Goal!");
        App.getStageModel().reset();
    }
}
