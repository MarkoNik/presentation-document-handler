package view.workspace.panels;

import model.workspace.Slide;
import view.MainFrame;
import view.workspace.SlideView;

import javax.swing.*;
import java.awt.*;

public class SlideShowPanel extends AbstractPresentationPanel {

    private CardLayout cardLayout;
    private JPanel jPanel;
    private JToolBar toolBar;
    private JButton prev, next;

    public SlideShowPanel() {

        toolBar = new JToolBar();
        toolBar.add(MainFrame.getInstance().getActionManager().getEditAction());

        prev = new JButton("<");
        next = new JButton(">");

        prev.addActionListener(e -> cardLayout.previous(jPanel));
        next.addActionListener(e -> cardLayout.next(jPanel));

        setLayout(new BorderLayout());
        add(toolBar, BorderLayout.NORTH);

        JPanel nav = new JPanel();
        nav.add(prev);
        nav.add(next);
        add(nav, BorderLayout.SOUTH);

        JPanel wrapper = new JPanel();
        Dimension d = new Dimension(900, 600);
        wrapper.setPreferredSize(d);
        wrapper.setMaximumSize(d);
        wrapper.setMinimumSize(d);
        jPanel = new JPanel();
        cardLayout = new CardLayout();
        jPanel.setLayout(cardLayout);
        wrapper.add(jPanel);
        add(wrapper, BorderLayout.CENTER);
    }

    @Override
    public void addSlide(SlideView slideView) {
        jPanel.add(slideView);
        validate();
    }

    @Override
    public void addNavSlide(SlideView slideView) {

    }

    @Override
    public void removeSlide(Slide slide) {
        int index = indexOfSlide(slide, jPanel);
        jPanel.remove(index);
        jPanel.validate();
    }

    @Override
    public void clearSlides() {
        jPanel.removeAll();
        jPanel.validate();
    }

}
