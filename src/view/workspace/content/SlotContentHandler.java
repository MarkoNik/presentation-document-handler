package view.workspace.content;

import view.workspace.SlotView;

public interface SlotContentHandler {
    void draw(SlotView slotView);
    void format(String content);
    void edit(SlotView slotView);
}
