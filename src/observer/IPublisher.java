package observer;

public interface IPublisher {
    void addSubscriber(ISubscriber sub);
    void removeSubscriber(ISubscriber sub);
    void notifySubscriber(Object notification);
}
