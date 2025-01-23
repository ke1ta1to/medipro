package medipro.subjects;

import java.util.ArrayList;
import java.util.List;

import medipro.input.IChangeTextEvent;

public class InputTextSubject {

    private static List<IChangeTextEvent> observers = new ArrayList<>();
    private static String text;

    public static String getText() {
        return text;
    }

    public static void setText(String text) {
        InputTextSubject.text = text;
        notifyObservers();
    }

    public static void addObserver(IChangeTextEvent observer) {
        observers.add(observer);
    }

    public static void removeObserver(IChangeTextEvent observer) {
        observers.remove(observer);
    }

    public static void notifyObservers() {
        observers.forEach(observer -> observer.changeText(text));
    }
}
