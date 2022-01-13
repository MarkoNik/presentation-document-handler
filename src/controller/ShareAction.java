package controller;

import main.Main;
import model.error.ERROR;
import model.error.ErrorFactory;
import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Slide;
import model.workspace.Workspace;
import view.MainFrame;
import view.gui.tree.model.RuTreeNode;
import view.gui.tree.view.RuTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ShareAction extends AbstractRudokAction {

    public ShareAction() {
        putValue(SMALL_ICON, loadIcon("icons/share.png"));
        putValue(NAME, "Share presentation");
        putValue(SHORT_DESCRIPTION, "Share presentation");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JDialog dialog = new JDialog();
        dialog.setTitle("Choose projects");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new GridLayout());
        dialog.setLocationRelativeTo(null);
        dialog.setSize(new Dimension(200, 200));

        RuTreeNode viewNode = (RuTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
        if (viewNode == null) {
            ErrorFactory.generate(ERROR.NODE_NOT_SELECTED).setVisible(true);
            return;
        }
        if (! (viewNode.getNode() instanceof Presentation)) {
            ErrorFactory.generate(ERROR.PRESENTATION_NOT_SELECTED).setVisible(true);
            return;
        }

        RuTreeNode root = (RuTreeNode) MainFrame.getInstance().getTree().getModel().getRoot();
        JComboBox<RuTreeNode> comboBox = new JComboBox<>();
        var iterator = root.children().asIterator();
        while(iterator.hasNext()) {
            comboBox.addItem((RuTreeNode) iterator.next());
        }

        JButton btn = new JButton("select");
        btn.addActionListener(e1 -> {

            RuTreeNode selected = (RuTreeNode) comboBox.getSelectedItem();
            assert selected != null;
            selected.add(viewNode);

            ((RuNodeComposite) selected.getNode()).addChild(viewNode.getNode());

            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
            dialog.dispose();
        });


        dialog.add(comboBox);
        dialog.add(btn);
        dialog.setVisible(true);
    }
}
