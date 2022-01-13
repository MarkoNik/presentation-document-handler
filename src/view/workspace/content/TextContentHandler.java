package view.workspace.content;

import model.content.TextContent;
import view.MainFrame;
import view.dialogs.TextDialog;
import view.workspace.SlotView;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.HashMap;
import java.util.Map;

public class TextContentHandler implements SlotContentHandler {
    @Override
    public void draw(SlotView slotView, Graphics2D g) {

        TextContent content = (TextContent) slotView.getSlot().getSlotContent();
        if (content.getSlotText() == null) return;
        AttributedString attributedString = new AttributedString(content.getSlotText());
        for (int i = 0; i < content.getSlotText().length(); i++) {

            Map<AttributedCharacterIterator.Attribute, Object> map = new HashMap<>();
            if (content.getBold().get(i)) {
                map.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
            }
            if (content.getItalic().get(i)) {
                map.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);
            }
            if (content.getUnderline().get(i)) {
                map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            }
            map.put(TextAttribute.SIZE, 20f);

            attributedString.addAttributes(map, i, i + 1);
        }

        g.setPaint(Color.BLACK);
        g.drawString(attributedString.getIterator(), slotView.getSlot().getPosition().x + 20, slotView.getSlot().getPosition().y + 20);
    }

    @Override
    public void edit(SlotView slotView) {
        new TextDialog(slotView);

    }
}
