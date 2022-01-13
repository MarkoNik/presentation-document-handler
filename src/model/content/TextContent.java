package model.content;

import java.util.Vector;

public class TextContent implements ISlotContent {
    private String text;
    private Vector<Boolean> bold;
    private Vector<Boolean> italic;
    private Vector<Boolean> underline;

    @Override
    public String getSlotText() {
        return text;
    }

    @Override
    public void setSlotText(String text) {
        this.text = text;
    }

    public void setVectors(Vector<Boolean> bold, Vector<Boolean> italic, Vector<Boolean> underline) {
        this.bold = bold;
        this.italic = italic;
        this.underline = underline;
    }

    public Vector<Boolean> getBold() {
        return bold;
    }

    public Vector<Boolean> getItalic() {
        return italic;
    }

    public Vector<Boolean> getUnderline() {
        return underline;
    }
}
