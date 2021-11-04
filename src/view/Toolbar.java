package view;

import javax.swing.*;
import java.awt.*;

public class Toolbar extends JToolBar {

    private static final long serialVersionUID = 1L;
    public Toolbar(){

        setFloatable(false);
        setBackground(new Color(255,255,204));
        add(MainFrame.getInstance().getActionManager().getNewAction());
        add(MainFrame.getInstance().getActionManager().getInfoAction());
    }
}
