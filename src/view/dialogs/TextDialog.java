package view.dialogs;

import model.content.ISlotContent;
import model.content.TextContent;
import model.workspace.Slot;
import view.workspace.SlotView;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.Vector;

public class TextDialog extends JDialog {

    private JTextPane textPane;

    public TextDialog(SlotView slotView) {
        setTitle("Edit text");
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout());
        setLocationRelativeTo(null);
        setSize(300, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());


        JButton boldBtn = new JButton("B");
        boldBtn.addActionListener(e -> formatText('b'));
        JButton italicBtn = new JButton("I");
        italicBtn.addActionListener(e -> formatText('i'));
        JButton underlineBtn = new JButton("U");
        underlineBtn.addActionListener(e -> formatText('u'));

        JButton continueBtn = new JButton("Continue");
        continueBtn.addActionListener(e -> {
            mapAttributes(slotView);
            dispose();
        });

        panel.add(boldBtn,BorderLayout.NORTH);
        panel.add(italicBtn, BorderLayout.WEST);
        panel.add(underlineBtn, BorderLayout.EAST);
        panel.add(continueBtn, BorderLayout.SOUTH);

        textPane = new JTextPane();
        panel.add(textPane,BorderLayout.CENTER);
        parse(slotView);

        add(panel);
        setVisible(true);
    }

    private void parse(SlotView slotView) {

        TextContent content = (TextContent) slotView.getSlot().getSlotContent();
        String text = content.getSlotText();
        if (text == null) return;
        Vector<Boolean> bold = content.getBold();
        Vector<Boolean> italic = content.getItalic();
        Vector<Boolean> underline = content.getUnderline();

        textPane.setText(text);
        StyledDocument document = textPane.getStyledDocument();
        for (int i = 0; i < text.length(); i++) {

            MutableAttributeSet attributes = new SimpleAttributeSet(document
                    .getCharacterElement(i)
                    .getAttributes()
                    .copyAttributes());

            StyleConstants.setBold(attributes, bold.get(i));
            StyleConstants.setItalic(attributes, italic.get(i));
            StyleConstants.setUnderline(attributes, underline.get(i));

            document.setCharacterAttributes(i, 1, attributes, true);
        }

    }

    public void formatText(char type) {

        StyledDocument document = textPane.getStyledDocument();
        String selected = textPane.getSelectedText();
        if (selected == null) return;
        int offset = textPane.getSelectionStart();
        for (int i = 0; i < selected.length(); i++) {

            MutableAttributeSet attributes = new SimpleAttributeSet(document
                                                .getCharacterElement(offset + i)
                                                .getAttributes()
                                                .copyAttributes());

            switch (type) {
                case 'b' -> StyleConstants.setBold(attributes, !StyleConstants.isBold(attributes));
                case 'i' -> StyleConstants.setItalic(attributes, !StyleConstants.isItalic(attributes));
                case 'u' -> StyleConstants.setUnderline(attributes, !StyleConstants.isUnderline(attributes));
            }

            document.setCharacterAttributes(offset + i, 1, attributes, true);
        }
    }

    private void mapAttributes(SlotView slotView) {

        Vector<Boolean> bold = new Vector<>();
        Vector<Boolean> italic = new Vector<>();
        Vector<Boolean> underline = new Vector<>();

        StyledDocument document = textPane.getStyledDocument();
        String text = textPane.getText();

        for (int i = 0; i < text.length(); i++) {

            AttributeSet attributes = document.getCharacterElement(i).getAttributes();
            bold.add(StyleConstants.isBold(attributes));
            italic.add(StyleConstants.isItalic(attributes));
            underline.add(StyleConstants.isUnderline(attributes));
        }

        ((TextContent) slotView.getSlot().getSlotContent()).setVectors(bold, italic, underline);
        slotView.getSlot().getSlotContent().setSlotText(text);
    }

}
