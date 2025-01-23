package medipro.observers;

import java.util.ArrayList;
import java.util.List;

import medipro.World;

public class WorldSubject {

    private List<IWorldObserver> observers = new ArrayList<>();
    private World world;

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
        notifyObservers();
    }

    public void addObserver(IWorldObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IWorldObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(observer -> observer.changeWorld(world));
    }

}
