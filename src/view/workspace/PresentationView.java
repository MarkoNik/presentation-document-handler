package view.workspace;
import model.error.ErrorFactory;
import model.message.NOTE;
import model.message.Notification;
import model.nodes.RuNode;
import model.workspace.Presentation;
import model.workspace.Slide;
import observer.ISubscriber;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PresentationView extends JPanel implements ISubscriber {

    private Presentation presentation;
    private List<SlideView> slides;
    private JPanel jPanel, navPanel;
    private JLabel author;
    private Image backgroundImage;

    public PresentationView(Presentation presentation) {

        setLayout(new BorderLayout());
        this.presentation = presentation;

        presentation.addSubscriber(this);
        slides = new ArrayList<>();
        jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        JScrollPane jScrollPane = new JScrollPane(jPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.getVerticalScrollBar().setUnitIncrement(16);

        navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));
        JScrollPane navigator = new JScrollPane(navPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        navigator.getVerticalScrollBar().setUnitIncrement(8);

        setBackGroundImage("autumn.jpg");


        author = new JLabel(presentation.getAuthor());
        add(author, BorderLayout.NORTH);
        add(navigator, BorderLayout.WEST);
        add(jScrollPane, BorderLayout.CENTER);
        for (RuNode node : presentation.getChildren()) {
            Slide slide = (Slide) node;
            SlideView slideView = new SlideView(slide, new Dimension(900, 600), backgroundImage);
            SlideView slideNav = new SlideView(slide, new Dimension(150, 100), backgroundImage);
            jPanel.add(slideView);
            navPanel.add(slideNav);
            jPanel.add(Box.createVerticalStrut(50));
            navPanel.add(Box.createVerticalStrut(25));
        }


    }

    private void setBackGroundImage(String path) {

        try {
            this.backgroundImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("themes/" + path))).getImage();
            backgroundImage = backgroundImage.getScaledInstance(900, 600, Image.SCALE_SMOOTH);

        } catch (Exception e) {
            ErrorFactory.generate(model.error.ERROR.WRONG_PATH).setVisible(true);
        }
    }


    @Override
    public void update(Notification notification) {

        NOTE note = notification.getType();
        switch(note) {

            case CHILD_ADDED: {
                Slide slide = (Slide) notification.getPayload();
                SlideView slideView = new SlideView(slide, new Dimension(900,600), backgroundImage);
                SlideView slideNav = new SlideView(slide, new Dimension(150,100), backgroundImage);
                slides.add(slideView);
                jPanel.add(slideView);
                jPanel.add(Box.createVerticalStrut(50));
                navPanel.add(slideNav);
                navPanel.add(Box.createVerticalStrut(25));
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

                index = 0;
                for (Component c : navPanel.getComponents()) {

                    if (!(c instanceof SlideView)) continue;
                    SlideView tmp = (SlideView) c;
                    if (tmp.getSlide().getId() == slide.getId()) {
                        break;
                    }
                    index++;
                }

                navPanel.remove(index);
                navPanel.remove(index);
                navPanel.validate();

                validate();
                break;
            }
            case AUTHOR_CHANGED: {
                String newAuthor = (String) notification.getPayload();
                author.setText(newAuthor);
                break;

            }

            case THEME_CHANGED: {
                String newPath = (String) notification.getPayload();
                setBackGroundImage(newPath);
                jPanel.removeAll();
                for (RuNode node : presentation.getChildren()) {
                    Slide slide = (Slide) node;
                    SlideView slideView = new SlideView(slide, new Dimension(900, 600), backgroundImage);
                    jPanel.add(slideView);
                    jPanel.add(Box.createVerticalStrut(50));
                }

                navPanel.removeAll();
                for (RuNode node : presentation.getChildren()) {
                    Slide slide = (Slide) node;
                    SlideView slideView = new SlideView(slide, new Dimension(150, 100), backgroundImage);
                    navPanel.add(slideView);
                    navPanel.add(Box.createVerticalStrut(25));
                }
                validate();
            }
        }


    }
}
