package View;

import javax.swing.*;

public class Menu extends JMenuBar {

    public Menu() {
        JMenu menuFile = new JMenu("File");
        menuFile.add(MainFrame.getInstance().getActionManager().getNewAction());
        add(menuFile);

        JMenu menuHelp = new JMenu("Help");
        menuHelp.add(MainFrame.getInstance().getActionManager().getInfoAction());
        add(menuHelp);

    }
}
