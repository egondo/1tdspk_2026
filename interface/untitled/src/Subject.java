import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> subscribers;

    public Subject() {
        subscribers = new ArrayList<>();
    }

    public void subscribe(Observer obs) {
        subscribers.add(obs);
    }

    public void unsubscribe(Observer obs) {
        subscribers.remove(obs);
    }

    public void notification() {
        for(Observer obs : subscribers) {
            obs.notification(this);
        }
    }
}