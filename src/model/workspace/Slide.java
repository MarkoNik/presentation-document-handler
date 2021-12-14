package model.workspace;

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
}
