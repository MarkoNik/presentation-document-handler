package model.error;

import javax.swing.*;
import java.awt.*;

public class UserError extends JDialog {
    private JPanel jPanel;
    private JLabel description;
    private JButton dismiss;

    public UserError(String desc) {

        super((Dialog) null, "Error", true);
        setSize(350, 100);
        setLocationRelativeTo(null);

        jPanel = new JPanel();
        description = new JLabel(desc, SwingConstants.CENTER);
        description.setFont(new Font("Arial", Font.PLAIN, 14));
        dismiss = new JButton("Dismiss");
        jPanel.setLayout(new BorderLayout());
        jPanel.add(description, BorderLayout.NORTH);
        jPanel.add(dismiss, BorderLayout.SOUTH);
        dismiss.addActionListener(e -> this.dispose());

        add(jPanel);
    }
}
