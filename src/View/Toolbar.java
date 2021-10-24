package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JToolBar {

    private static final long serialVersionUID = 1L;
    public Toolbar(){

        setFloatable(false);
        setBackground(new Color(255,255,204));
        add(MainFrame.getInstance().getActionManager().getNewAction());
        add(MainFrame.getInstance().getActionManager().getInfoAction());
    }
}
