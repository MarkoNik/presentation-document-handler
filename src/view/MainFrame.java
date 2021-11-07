package view;

import controller.ActionManager;
import model.workspace.Workspace;
import view.gui.tree.model.RuTreeNode;
import view.gui.tree.view.RuTree;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instance = null;
    private Menu menu;
    private Toolbar toolbar;
    private ActionManager actionManager;


    private RuTree tree;




    private MainFrame() throws HeadlessException { }

    private void init() {
        actionManager = new ActionManager();
    }

    private void initGUI() {
        setLayout(new BorderLayout());
        setTitle("RuDok");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width / 2, screenSize.height / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu = new Menu();
        setJMenuBar(menu);
        add(new Toolbar(), BorderLayout.NORTH);

        JPanel desktop = new JPanel();


        Workspace ws = new Workspace("Workspace", null);
        RuTreeNode mtn = new RuTreeNode(ws);
        tree = new RuTree(mtn);
        JScrollPane scroll = new JScrollPane(tree);


        scroll.setMinimumSize(new Dimension(200, 150));
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, desktop);
        getContentPane().add(split, BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);







        setVisible(true);
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
            instance.init();
            instance.initGUI();
        }
        return instance;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public RuTree getTree() {
        return tree;
    }

    public void setTree(RuTree tree) {
        this.tree = tree;
    }
}
