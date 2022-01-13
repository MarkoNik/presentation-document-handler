package model.content;

import java.io.Serializable;

public interface ISlotContent extends Serializable {
    String getSlotText();
    void setSlotText(String text);
}
