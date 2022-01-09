package model.workspace;

import model.message.NOTE;
import model.message.Notification;
import model.nodes.RuNode;

import java.util.ArrayList;
import java.util.List;

public class Slide extends RuNode {
    private int id;
    private List<Slot> slots;

    public Slide(String name, RuNode parent, int id) {
        super(name, parent);
        slots = new ArrayList<>();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addSlot(Slot slot) {
        slots.add(slot);
        notifySubscriber(new Notification(NOTE.SLOT_ADDED, slot));
    }

    public void removeSlot(Slot slot) {
        slots.remove(slot);
        notifySubscriber(new Notification(NOTE.SLOT_DELETED, slot));
    }

    public List<Slot> getSlots() {
        return slots;
    }
}
