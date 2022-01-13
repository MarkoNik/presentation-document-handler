package model.workspace;

import model.message.NOTE;
import model.message.Notification;
import model.nodes.RuNode;
import model.nodes.RuNodeComposite;

import java.io.File;
import java.io.Serial;
import java.util.ArrayList;

public class Project extends RuNodeComposite {

    private File projectFile;

    public Project(String name, RuNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(RuNode child) {
        if (child instanceof Presentation) {
            children.add(child);
            notifySubscriber(new Notification(NOTE.CHILD_ADDED, child));
        } else {
            System.err.println("Prosledjujes pogresnu stvar");
        }
        maxChild++;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        notifySubscriber(new Notification(NOTE.NAME_CHANGED, name));
    }

    public File getProjectFile() {
        return projectFile;
    }

    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
    }

    @Serial
    protected Object readResolve(){
        subscribers = new ArrayList<>();
        return this;
    }
}
