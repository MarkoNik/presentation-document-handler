package view.workspace;

import model.message.NOTE;
import model.message.Notification;
import model.workspace.Presentation;
import model.workspace.Slide;
import observer.ISubscriber;
import view.MainFrame;
import view.gui.tree.model.RuTreeNode;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.Flow;

public class PresentationView extends JPanel implements ISubscriber {

    private Presentation presentation;
    private List<SlideView> slides;
    private JPanel jPanel;

    public PresentationView(Presentation presentation) {

        setLayout(new BorderLayout());

        presentation.addSubscriber(this);
        slides = new ArrayList<>();
        jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        JScrollPane jScrollPane = new JScrollPane(jPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        JLabel author = new JLabel(presentation.getAuthor());
        add(author, BorderLayout.NORTH);
        add(jScrollPane, BorderLayout.CENTER);
        for (SlideView slide : slides) {
            jPanel.add(slide);
        }


    }


    @Override
    public void update(Notification notification) {

        NOTE note = notification.getType();
        switch(note) {

            case CHILD_ADDED: {
                Slide slide = (Slide) notification.getPayload();
                SlideView slideView = new SlideView(slide, new Dimension(1000, 500));
                slides.add(slideView);
                jPanel.add(slideView);
                jPanel.add(Box.createVerticalStrut(50));
                validate();
                break;

            }
            case AUTHOR_CHANGED: {
                String newAuthor = (String) notification.getPayload();
                break;

            }
        }


    }
}
