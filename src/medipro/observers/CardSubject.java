package medipro.observers;

import java.util.ArrayList;
import java.util.List;

public class CardSubject {
    private List<ICardObserver> observers = new ArrayList<>();
    private String cardNumber;// カードの番号

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        notifyObservers();
    }

    public void addObserver(ICardObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ICardObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(observer -> observer.changeCardNumber(cardNumber));
    }
}
