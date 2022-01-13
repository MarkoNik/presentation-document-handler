package view;

import command.CommandManager;
import controller.ActionManager;
import model.workspace.Workspace;
import view.dialogs.PickContextDialog;
import view.gui.tree.model.RuTreeNode;
import view.gui.tree.view.RuTree;
import view.workspace.ProjectView;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instance = null;
    private Menu menu;
    private ActionManager actionManager;
    private CommandManager commandManager;
    private JPanel desktop;
    private JSplitPane split;
    private JPanel workspace;
    private ProjectView projectView;

    private RuTree tree;


    private MainFrame() throws HeadlessException {
    }

    private void init() {
        actionManager = new ActionManager();
        commandManager = new CommandManager();
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

        desktop = new JPanel();


        Workspace ws = new Workspace("Workspace", null);
        RuTreeNode mtn = new RuTreeNode(ws);
        tree = new RuTree(mtn);
        JScrollPane scroll = new JScrollPane(tree);
        PickContextDialog contextDialog = new PickContextDialog();


        scroll.setMinimumSize(new Dimension(200, 150));
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, desktop);
        getContentPane().add(split, BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);


        workspace = new JPanel();
        workspace.setLayout(new BorderLayout());
        split.add(workspace, JSplitPane.RIGHT);


        projectView = new ProjectView();
        workspace.add(projectView);


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

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public RuTree getTree() {
        return tree;
    }

    public void setTree(RuTree tree) {
        this.tree = tree;
    }

    public JPanel getWorkspace() {
        return workspace;
    }

    public ProjectView getProjectView() {
        return projectView;
    }
}
