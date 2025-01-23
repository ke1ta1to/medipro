package medipro.observers;

import java.util.ArrayList;
import java.util.List;

public class InputTextSubject {

    private List<IInputTextObserver> observers = new ArrayList<>();
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyObservers();
    }

    public void addObserver(IInputTextObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IInputTextObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(observer -> observer.changeText(text));
    }
}
