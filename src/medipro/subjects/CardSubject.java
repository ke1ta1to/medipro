package medipro.subjects;

import java.util.ArrayList;
import java.util.List;

public class CardSubject {
    private static List<Runnable> observers = new ArrayList<>();
    private static String cardNumber;// カードの番号

    public static String getCardNumber() {
        return cardNumber;
    }

    public static void setCardNumber(String cardNumber) {
        CardSubject.cardNumber = cardNumber;
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
