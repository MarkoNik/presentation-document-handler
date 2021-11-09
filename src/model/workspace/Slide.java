package model.workspace;

import model.nodes.RuNode;

public class Slide extends RuNode {
    private int id;

    public Slide(String name, RuNode parent, int id) {
        super(name, parent);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
