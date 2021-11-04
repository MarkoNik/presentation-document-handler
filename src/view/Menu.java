package view;

import javax.swing.*;

public class Menu extends JMenuBar {

    public Menu() {
        JMenu menuFile = new JMenu("File");
        menuFile.add(MainFrame.getInstance().getActionManager().getNewAction());

        JMenu menuFilePresentation = new JMenu("Presentation");

        menuFilePresentation.add(MainFrame.getInstance().getActionManager().getChangeAuthorAction());
        menuFilePresentation.add(MainFrame.getInstance().getActionManager().getChangeThemeAction());

        menuFile.add(menuFilePresentation);
        add(menuFile);

        JMenu menuHelp = new JMenu("Help");
        menuHelp.add(MainFrame.getInstance().getActionManager().getInfoAction());
        add(menuHelp);
    }
}
