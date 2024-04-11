package test.src.Actions;

import javax.swing.*;

import test.src.Utils.StatusCode;

import java.awt.event.*;

public class MenuItemAction extends JMenu implements ActionListener {
    // constructor
    public MenuItemAction() { }

    // public methods
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("About XML Editor")) {
            aboutAction(e);
        } else if (e.getActionCommand().equals("Quit (Control + Q)")) {
            exitAction(e);
        }
    }

    // private methods
    private void aboutAction(ActionEvent e) {
        String message = "Hello World! This is a simple XML Editor.";
        JOptionPane.showMessageDialog(null, message);
    }

    private void exitAction(ActionEvent e) {
        System.exit(StatusCode.EXIT);
    }
}