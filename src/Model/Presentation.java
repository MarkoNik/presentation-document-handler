package Model;

public class Presentation extends RuNodeComposite {
    private String author;
    private String backgroundPath;

    public Presentation(String name, RuNode parent, String author, String backgroundPath) {
        super(name, parent);
        this.author = author;
        this.backgroundPath = backgroundPath;
    }

    @Override
    public void addChild(RuNode child) {
        if (child instanceof Slide) {
            children.add(child);
        } else {
            System.err.println("Prosledjujes pogresnu stvar");
        }
    }
}
