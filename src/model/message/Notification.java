package model.message;

public class Notification {


    private NOTE type;
    private Object payload;

    public Notification(NOTE type, Object payload) {
        this.type = type;
        this.payload = payload;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public NOTE getType() {
        return type;
    }

    public void setType(NOTE type) {
        this.type = type;
    }
}
