package view.workspace;

import model.message.NOTE;
import model.message.Notification;
import model.workspace.Presentation;
import model.workspace.Project;
import observer.ISubscriber;
import view.MainFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ProjectView extends JPanel implements ISubscriber {
    private Project project;
    private JTabbedPane jTabbedPane;

    public ProjectView() {

        setLayout(new BorderLayout());
        jTabbedPane = new JTabbedPane();
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
            }
        }
    }

    public void setProject(Project project) {
        this.project = project;
        project.addSubscriber(this);
        JLabel name = new JLabel(project.getName());
        add(name, BorderLayout.NORTH);
        add(jTabbedPane, BorderLayout.CENTER);
        jTabbedPane.validate();
    }


}
