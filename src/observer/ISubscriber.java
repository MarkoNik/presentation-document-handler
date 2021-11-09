package observer;

import model.message.Notification;

public interface ISubscriber {
    void update(Notification notification);
}
