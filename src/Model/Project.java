package Model;

public class Project extends RuNodeComposite {
    public Project(String name, RuNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(RuNode child) {
        if (child instanceof Presentation) {
            children.add(child);
        } else {
            System.err.println("Prosledjujes pogresnu stvar");
        }
    }
}
