package view.workspace;
import model.error.ErrorFactory;
import model.message.NOTE;
import model.message.Notification;
import model.nodes.RuNode;
import model.workspace.Presentation;
import model.workspace.Slide;
import observer.ISubscriber;
import state.presentation.PresentationStateManager;
import state.slot.SlotStateManager;
import view.workspace.panels.AbstractPresentationPanel;
import view.workspace.panels.EditPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PresentationView extends JPanel implements ISubscriber {

    private Presentation presentation;
    private AbstractPresentationPanel canvas;
    private JLabel author;
    private Image backgroundImage;

    private SlotStateManager slotStateManager;
    private PresentationStateManager presentationStateManager;

    public PresentationView(Presentation presentation) {

        this.presentation = presentation;
        slotStateManager = new SlotStateManager();
        presentationStateManager = new PresentationStateManager();

        presentation.getSubscribers().clear();
        presentation.addSubscriber(this);
        setBackGroundImage("autumn.jpg");

        author = new JLabel(presentation.getAuthor());
        canvas = new EditPanel();

        reload();

        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);
        add(author, BorderLayout.SOUTH);
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
        switch (note) {
            case CHILD_ADDED -> {
                Slide slide = (Slide) notification.getPayload();
                addSlide(slide);
                validate();
            }
            case CHILD_REMOVED -> {
                Slide slide = (Slide) notification.getPayload();
                canvas.removeSlide(slide);
                validate();
            }
            case AUTHOR_CHANGED -> {
                String newAuthor = (String) notification.getPayload();
                author.setText(newAuthor);
            }
            case THEME_CHANGED -> {
                String newPath = (String) notification.getPayload();
                setBackGroundImage(newPath);
                canvas.clearSlides();
                reload();
                validate();
            }
        }
    }


    public void startCreateSlot() {
        slotStateManager.setCreateState();
    }
    public void startDeleteSlot() {
        slotStateManager.setDeleteState();
    }
    public void startMoveSlot() {
        slotStateManager.setMoveState();
    }
    public void mousePressed(MouseEvent e, SlideView slideView) {
        slotStateManager.getState().mouseClick(e, slideView);
    }
    public void mouseDragged(MouseEvent e, SlideView slideView) {
        slotStateManager.getState().mouseDrag(e, slideView);
    }

    public void startSlideShow() {
        presentationStateManager.setSlideShowState();
        slotStateManager.setSleepState();
        changeState();
    }

    public void startEdit() {
        presentationStateManager.setEditState();
        changeState();
    }

    public void changeState()  {
        remove(canvas);
        canvas = presentationStateManager.getPresentationState().initComponent();
        add(canvas);
        reload();
        validate();
    }

    private void reload() {
        for (RuNode node : presentation.getChildren()) {
            addSlide((Slide) node);
        }
    }

    private void addSlide(Slide slide) {
        SlideView slideView = new SlideView(slide, new Dimension(900, 600), backgroundImage, this);
        canvas.addSlide(slideView);
        canvas.addNavSlide(scaled(slideView));
    }

    private SlideView scaled(SlideView slideView) {
        Slide slide = slideView.getSlide();
        return new SlideView(slide, new Dimension(150, 100), backgroundImage, this);
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    public boolean isText() {
        return ((EditPanel) canvas).isText();
    }
}
