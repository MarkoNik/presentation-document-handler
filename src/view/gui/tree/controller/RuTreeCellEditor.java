package view.gui.tree.controller;

import model.error.ERROR;
import model.error.ErrorFactory;
import view.gui.tree.model.RuTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class RuTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    private Object clickedOn = null;
    private JTextField edit = null;

    public RuTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0, arg1);
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
        //super.getTreeCellEditorComponent(arg0,arg1,arg2,arg3,arg4,arg5);
        clickedOn =arg1;
        edit=new JTextField(arg1.toString());
        edit.addActionListener(this);
        return edit;
    }



    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent)
            return ((MouseEvent) arg0).getClickCount() == 3;
        return false;
    }



    public void actionPerformed(ActionEvent e){

        if (!(clickedOn instanceof RuTreeNode))
            return;

        RuTreeNode clicked = (RuTreeNode) clickedOn;

        if (e.getActionCommand().isBlank()) {
            ErrorFactory.generate(ERROR.BLANK_NAME).setVisible(true);
            return;
        }

        clicked.setName(e.getActionCommand());
        (clicked.getNode()).setName(e.getActionCommand());



    }

}
