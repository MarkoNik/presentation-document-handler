package view.dialogs;

import model.nodes.RuNode;
import model.workspace.Presentation;
import view.MainFrame;
import view.gui.tree.model.RuTreeNode;

import javax.swing.*;
import java.awt.*;

public class ChangeAuthorDialog extends JDialog {
    public ChangeAuthorDialog() {
        super(MainFrame.getInstance(), "Change Author", true);
        setSize(300, 130);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        JLabel text = new JLabel("Enter new author name", SwingConstants.CENTER);
        JTextField input = new JTextField();
        input.setPreferredSize(new Dimension(100, 30));
        panel.add(input);

        JButton button = new JButton("OK");

        add(text, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        button.addActionListener(e -> {
            RuTreeNode viewNode = (RuTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
            if (viewNode == null) {
                return;
            }
            RuNode node = viewNode.getNode();
            if (input.getText().isBlank()) {
                //TODO error
                return;
            }

            String newAuthor = input.getText();
            ((Presentation) node).setAuthor(newAuthor);
            dispose();
        });

        setVisible(true);
    }
}
