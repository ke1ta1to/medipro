package medipro.cardobserver;

import java.util.ArrayList;
import java.util.List;

public class CardSubject {
    private static List<CardObserver> observers = new ArrayList<>();
    private static String cardNumber;// カードの番号

    public static String getCardNumber() {
        return cardNumber;
    }

    public static void setCardNumber(String cardNumber) {
        CardSubject.cardNumber = cardNumber;
        notifyObservers();
    }

    public static void addObserver(CardObserver observer) {
        observers.add(observer);
    }

    public static void removeObserver(CardObserver observer) {
        observers.remove(observer);
    }

    public static void notifyObservers() {
        for (CardObserver observer : observers) {
            observer.update();
        }
    }
}
