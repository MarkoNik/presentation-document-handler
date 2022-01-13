package view.workspace.content;

import model.workspace.Slot;
import view.MainFrame;
import view.workspace.SlotView;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Position;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageContentHandler implements SlotContentHandler {
    private Image image;
    private String path;

    @Override
    public void draw(SlotView slotView, Graphics2D g) {
        Point position = slotView.getSlot().getPosition();
        try {
            image = ImageIO
                    .read(new File(slotView.getSlot().getSlotContent().getSlotText()))
                    .getScaledInstance(Slot.slotDimension.width, Slot.slotDimension.height, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(image, position.x, position.y, null);

    }

    @Override
    public void edit(SlotView slotView) {
        JDialog dialog = new JDialog();
        Dimension d = new Dimension(215, 250);
        dialog.setMinimumSize(d);
        dialog.setMaximumSize(d);
        dialog.setPreferredSize(d);
        dialog.setTitle("Edit image");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new GridLayout());
        dialog.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel preview = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
        panel.setMinimumSize(Slot.slotDimension);
        panel.add(preview);

        JButton editBtn = new JButton("Edit");
        editBtn.addActionListener(e -> {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "JPG & GIF Images", "jpg", "gif");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(MainFrame.getInstance());
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    path = chooser.getSelectedFile().getCanonicalPath();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                try {
                    image = ImageIO
                            .read(chooser
                                    .getSelectedFile())
                            .getScaledInstance(Slot.slotDimension.width, Slot.slotDimension.height, Image.SCALE_DEFAULT);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                preview.repaint();
            }
        });
        panel.add(editBtn);


        JButton continueBtn = new JButton("Continue");
        continueBtn.addActionListener(e -> {
            slotView.getSlot().getSlotContent().setSlotText(path);
            dialog.dispose();
        });
        panel.add(continueBtn);


        dialog.add(panel);
        dialog.pack();
        dialog.setVisible(true);
    }
}
