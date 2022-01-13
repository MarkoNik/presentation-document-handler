package view.dialogs;

import view.MainFrame;

import javax.swing.*;
import java.awt.*;

public class PickContextDialog extends JDialog {

    public PickContextDialog() {

        setTitle("Pick context");
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout());
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JToolBar bar = new JToolBar();
        bar.add(MainFrame.getInstance().getActionManager().getOpenWorkspaceAction());
        panel.add(bar, BorderLayout.NORTH);

        JButton noContextBtn = new JButton("Continue");
        noContextBtn.addActionListener(e -> dispose());
        panel.add(noContextBtn, BorderLayout.SOUTH);

        add(panel);
        pack();
        setVisible(true);

    }

}
