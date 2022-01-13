package view.workspace.panels;

import model.content.Type;
import model.nodes.RuNode;
import model.workspace.Presentation;
import model.workspace.Slide;
import model.workspace.Slot;
import view.MainFrame;
import view.workspace.PresentationView;
import view.workspace.SlideView;
import view.workspace.SlotView;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EditPanel extends AbstractPresentationPanel {

    private JPanel jPanel, navPanel;
    private JToolBar toolBar;
    private JRadioButton text = new JRadioButton("text");
    private JRadioButton image = new JRadioButton("image");

    public EditPanel() {

        toolBar = new JToolBar();
        toolBar.add(MainFrame.getInstance().getActionManager().getSlideShowAction());
        toolBar.add(MainFrame.getInstance().getActionManager().getCreateSlotAction());
        toolBar.add(MainFrame.getInstance().getActionManager().getDeleteSlotAction());
        toolBar.add(MainFrame.getInstance().getActionManager().getMoveSlotAction());
        toolBar.add(MainFrame.getInstance().getActionManager().getColorChooserAction());
        text.setSelected(true);
        ButtonGroup bg = new ButtonGroup();
        bg.add(text);
        bg.add(image);
        toolBar.add(text);
        toolBar.add(image);


        JComboBox<Float> jComboBox = new JComboBox<>();
        jComboBox.setMaximumSize(new Dimension(60, 40));
        for (float x = 0; x <= 15; x += 0.5f) {
            jComboBox.addItem(x);
        }
        jComboBox.setSelectedItem(5f);
        jComboBox.addActionListener(e -> {
            Presentation presentation = ((PresentationView) MainFrame.getInstance().getProjectView()
                    .getjTabbedPane().getSelectedComponent()).getPresentation();
            presentation.setLineWidth((Float) jComboBox.getSelectedItem());
        });
        toolBar.add(jComboBox);

        JCheckBox jCheckBox = new JCheckBox("Dash");
        jCheckBox.addActionListener(e -> {
            Presentation presentation = ((PresentationView) MainFrame.getInstance().getProjectView()
                    .getjTabbedPane().getSelectedComponent()).getPresentation();
            presentation.setDash(!presentation.isDash());
        });
        toolBar.add(jCheckBox);


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
        // sortiraj po indexu i dodaj na mesto
    }

    @Override
    public void addNavSlide(SlideView slideView) {
        navPanel.add(slideView);
        navPanel.add(Box.createVerticalStrut(25));
        navPanel.validate();
        // sortiraj po indexu i dodaj na mesto
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

    public boolean isText() {
        return text.isSelected();
    }

}
