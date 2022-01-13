package view.workspace.content;

import view.MainFrame;
import view.workspace.SlotView;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import java.awt.*;

public class TextContentHandler implements SlotContentHandler {
    @Override
    public void draw(SlotView slotView) {

    }

    @Override
    public void format(String content) {
        SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();

    }

    @Override
    public void edit(SlotView slotView) {

        JDialog dialog = new JDialog();
        dialog.setTitle("Edit text");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new GridLayout());
        dialog.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextField textField = new JTextField();
        panel.add(textField,BorderLayout.NORTH);

        JButton continueBtn = new JButton("Continue");
        continueBtn.addActionListener(e -> {
            slotView.getSlot().setContent(textField.getText());
            dialog.dispose();
        });

        panel.add(continueBtn, BorderLayout.SOUTH);

        dialog.add(panel);
        dialog.pack();
        dialog.setVisible(true);
    }
}
