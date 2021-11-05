package view;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class Toolbar extends JToolBar {

    @Serial
    private static final long serialVersionUID = 1L;
    public Toolbar(){

        setFloatable(false);
        setBackground(new Color(62, 155, 213));
        add(MainFrame.getInstance().getActionManager().getNewAction());
        add(MainFrame.getInstance().getActionManager().getInfoAction());
        add(MainFrame.getInstance().getActionManager().getChangeAuthorAction());
        add(MainFrame.getInstance().getActionManager().getChangeThemeAction());
    }
}
