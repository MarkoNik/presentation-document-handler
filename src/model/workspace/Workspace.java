package model.workspace;

import model.message.NOTE;
import model.message.Notification;
import model.nodes.RuNode;
import model.nodes.RuNodeComposite;

import java.io.File;
import java.io.Serial;
import java.util.ArrayList;

public class Workspace extends RuNodeComposite {

    private File workspaceDirectory;

    public Workspace(String name, RuNode parent) {
        super(name, parent);
    }


    @Override
    public void addChild(RuNode child) {
        if (child instanceof Project) {
            children.add(child);
        } else {
            System.err.println("Prosledjujes pogresnu stvar");
        }
        maxChild++;
    }

    @Override
    public void removeChild(RuNode child) {

        children.remove(child);
        child.notifySubscriber(new Notification(NOTE.NODE_REMOVED, child));
    }

    public File getWorkspaceDirectory() {
        return workspaceDirectory;
    }

    public void setWorkspaceDirectory(File workspaceDirectory) {
        this.workspaceDirectory = workspaceDirectory;
    }

    @Serial
    protected Object readResolve(){
        subscribers = new ArrayList<>();
        return this;
    }
}
