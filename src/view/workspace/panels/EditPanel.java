package view.workspace.panels;

import model.nodes.RuNode;
import model.workspace.Presentation;
import model.workspace.Slide;
import view.MainFrame;
import view.workspace.SlideView;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EditPanel extends AbstractPresentationPanel {

    private JPanel jPanel, navPanel;
    private JToolBar toolBar;

    public EditPanel() {

        toolBar = new JToolBar();
        toolBar.add(MainFrame.getInstance().getActionManager().getSlideShowAction());
        toolBar.add(MainFrame.getInstance().getActionManager().getCreateSlotAction());
        toolBar.add(MainFrame.getInstance().getActionManager().getDeleteSlotAction());
        toolBar.add(MainFrame.getInstance().getActionManager().getMoveSlotAction());


        jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        JScrollPane jScrollPane = new JScrollPane(jPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.getVerticalScrollBar().setUnitIncrement(16);


        navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));
        JScrollPane navigator = new JScrollPane(navPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        navigator.getVerticalScrollBar().setUnitIncrement(8);


        setLayout(new BorderLayout());
        add(toolBar, BorderLayout.NORTH);
        add(navigator, BorderLayout.WEST);
        add(jScrollPane, BorderLayout.CENTER);

    }

    @Override
    public void addSlide(SlideView slideView) {
        jPanel.add(slideView);
        jPanel.add(Box.createVerticalStrut(50));
        jPanel.validate();
    }

    @Override
    public void addNavSlide(SlideView slideView) {
        navPanel.add(slideView);
        navPanel.add(Box.createVerticalStrut(25));
        navPanel.validate();
    }

    @Override
    public void removeSlide(Slide slide) {

        int index = indexOfSlide(slide, jPanel);
        jPanel.remove(index);
        jPanel.remove(index);
        navPanel.remove(index);
        navPanel.remove(index);

        jPanel.validate();
        navPanel.validate();
    }

    @Override
    public void clearSlides() {
        jPanel.removeAll();
        navPanel.removeAll();
        jPanel.validate();
        navPanel.validate();
    }
}
