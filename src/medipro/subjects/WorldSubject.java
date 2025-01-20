package medipro.subjects;

import java.util.ArrayList;
import java.util.List;

import medipro.World;

public class WorldSubject {

    private static List<Runnable> observers = new ArrayList<>();
    private static World world;

    public static World getWorld() {
        return world;
    }

    public static void setWorld(World world) {
        WorldSubject.world = world;
        notifyObservers();
    }

    public static void addObserver(Runnable observer) {
        observers.add(observer);
    }

    public static void removeObserver(Runnable observer) {
        observers.remove(observer);
    }

    public static void notifyObservers() {
        observers.forEach(observer -> observer.run());
    }

}
