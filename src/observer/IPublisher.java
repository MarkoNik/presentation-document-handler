package observer;

import model.message.Notification;

public interface IPublisher {
    void addSubscriber(ISubscriber sub);
    void removeSubscriber(ISubscriber sub);
    void notifySubscriber(Notification notification);
}
