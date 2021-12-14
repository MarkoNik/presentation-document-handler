package view.workspace;

import model.message.NOTE;
import model.message.Notification;
import model.nodes.RuNode;
import model.workspace.Presentation;
import model.workspace.Project;
import observer.ISubscriber;

import javax.swing.*;
import java.awt.*;

public class ProjectView extends JPanel implements ISubscriber {

    private Project project;
    private JTabbedPane jTabbedPane;
    private JLabel name;

    public ProjectView() {

        setLayout(new BorderLayout());
        jTabbedPane = new JTabbedPane();
        name = new JLabel("LBL", SwingConstants.CENTER);
    }

    @Override
    public void update(Notification notification) {
        NOTE note = notification.getType();
        switch(note) {

            case CHILD_ADDED: {
                Presentation presentation = (Presentation) notification.getPayload();
                PresentationView presentationView = new PresentationView(presentation);
                jTabbedPane.addTab(presentation.getName(), presentationView);
                jTabbedPane.validate();
                break;
            }

            case NODE_REMOVED: {
                project = null;
                name.setText("");
                jTabbedPane.removeAll();
                break;
            }

            case NAME_CHANGED: {
                String name = (String) notification.getPayload();
                this.name.setText(name);
                break;
            }

            case PRESENTATION_NAME_CHANGED: {
                loadTabs();

            }
        }
    }

    public void setProject(Project project) {

        this.project = project;
        this.project.addSubscriber(this);
        name.setText(this.project.getName());
        add(name, BorderLayout.NORTH);
        add(jTabbedPane, BorderLayout.CENTER);
        loadTabs();
        jTabbedPane.validate();
    }

    private void loadTabs() {

        jTabbedPane.removeAll();
        for (RuNode p : this.project.getChildren()) {
            Presentation presentation = (Presentation) p;
            PresentationView presentationView = new PresentationView(presentation);
            jTabbedPane.addTab(presentation.getName(), presentationView);
        }
    }

    public JTabbedPane getjTabbedPane() {
        return jTabbedPane;
    }
}
