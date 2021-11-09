package view.workspace;

import model.message.NOTE;
import model.message.Notification;
import model.nodes.RuNode;
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
    private JLabel author;

    public PresentationView(Presentation presentation) {

        setLayout(new BorderLayout());

        presentation.addSubscriber(this);
        slides = new ArrayList<>();
        jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        JScrollPane jScrollPane = new JScrollPane(jPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.getVerticalScrollBar().setUnitIncrement(16);


        author = new JLabel(presentation.getAuthor());
        add(author, BorderLayout.NORTH);
        add(jScrollPane, BorderLayout.CENTER);
        for (RuNode node : presentation.getChildren()) {
            Slide slide = (Slide) node;
            SlideView slideView = new SlideView(slide, new Dimension(900, 600));
            jPanel.add(slideView);
        }


    }


    @Override
    public void update(Notification notification) {

        NOTE note = notification.getType();
        switch(note) {

            case CHILD_ADDED: {
                Slide slide = (Slide) notification.getPayload();
                SlideView slideView = new SlideView(slide, new Dimension(900,600));
                slides.add(slideView);
                jPanel.add(slideView);
                jPanel.add(Box.createVerticalStrut(50));
                validate();
                break;

            }
            case CHILD_REMOVED: {
                Slide slide = (Slide) notification.getPayload();
                int index = 0;
                for (Component c : jPanel.getComponents()) {

                    if (!(c instanceof SlideView)) continue;
                    SlideView tmp = (SlideView) c;
                    if (tmp.getSlide().getId() == slide.getId()) {
                        break;
                    }
                    index++;
                }

                jPanel.remove(index);
                jPanel.remove(index);
                jPanel.validate();
                break;
            }
            case AUTHOR_CHANGED: {
                String newAuthor = (String) notification.getPayload();
                author.setText(newAuthor);
                break;

            }
        }


    }
}
