package model.content;

public class ImageContent implements ISlotContent {
    private String text;

    @Override
    public void setSlotText(String text) {
        this.text = text;
    }

    @Override
    public String getSlotText() {
        return text;
    }
}
