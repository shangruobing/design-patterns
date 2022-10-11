package observer;

import java.util.ArrayList;

/**
 * @author Ruobing Shang 2022-10-11 9:02
 */
public abstract class Publisher {
    private final ArrayList<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(Object context) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(context);
        }
    }
}
