package Model;

public class Slide extends RuNode {
    private int id;

    public Slide(String name, RuNode parent, int id) {
        super(name, parent);
        this.id = id;
    }
}
