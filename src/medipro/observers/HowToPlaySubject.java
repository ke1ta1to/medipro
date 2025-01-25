package medipro.observers;

import java.util.ArrayList;
import java.util.List;

public class HowToPlaySubject {
    private List<IHowToPlayObserver> observers = new ArrayList<>();
    private String howToPlayNumber;// カードの番号

    public String getHowToPlayNumber() {
        return howToPlayNumber;
    }

    public void setHowToPlayNumber(String cardNumber) {
        this.howToPlayNumber = cardNumber;
        notifyObservers();
    }

    public void addObserver(IHowToPlayObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IHowToPlayObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(observer -> observer.changeHowToPlayNumber(howToPlayNumber));
    }
}
