package model.workspace;

import model.message.NOTE;
import model.message.Notification;
import model.nodes.RuNode;
import model.nodes.RuNodeComposite;

public class Presentation extends RuNodeComposite {


    private String author;
    private String backgroundPath;
    private Slot selectedSlot;


    public Presentation(String name, RuNode parent, String author) {
        super(name, parent);
        this.author = author;
    }

    public Presentation(String name, RuNode parent, String author, String backgroundPath) {
        super(name, parent);
        this.author = author;
        this.backgroundPath = backgroundPath;
    }

    @Override
    public void addChild(RuNode child) {
        if (child instanceof Slide) {
            children.add(child);
            notifySubscriber(new Notification(NOTE.CHILD_ADDED, child));
        } else {
            System.err.println("Prosledjujes pogresnu stvar");
        }
        maxChild++;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
        notifySubscriber(new Notification(NOTE.AUTHOR_CHANGED, author));
    }


    @Override
    public void setName(String name) {
        super.setName(name);
        getParent().notifySubscriber(new Notification(NOTE.PRESENTATION_NAME_CHANGED, null));
    }

    public String getBackgroundPath() {
        return backgroundPath;
    }

    public void setBackgroundPath(String backgroundPath) {
        this.backgroundPath = backgroundPath;
        notifySubscriber(new Notification(NOTE.THEME_CHANGED, backgroundPath));
    }

    public Slot getSelectedSlot() {
        return selectedSlot;
    }

    public void setSelectedSlot(Slot selectedSlot) {
        this.selectedSlot = selectedSlot;
    }
}
