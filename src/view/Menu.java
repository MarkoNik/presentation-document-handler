package view;

import javax.swing.*;

public class Menu extends JMenuBar {

    public Menu() {
        JMenu menuFile = new JMenu("File");
        menuFile.add(MainFrame.getInstance().getActionManager().getNewAction());
        menuFile.add(MainFrame.getInstance().getActionManager().getDeleteAction());
        add(menuFile);


        JMenu menuEdit = new JMenu("Edit");
        menuEdit.add(MainFrame.getInstance().getActionManager().getChangeAuthorAction());
        menuEdit.add(MainFrame.getInstance().getActionManager().getChangeThemeAction());
        add(menuEdit);


        JMenu menuHelp = new JMenu("Help");
        menuHelp.add(MainFrame.getInstance().getActionManager().getInfoAction());
        add(menuHelp);
    }
}
