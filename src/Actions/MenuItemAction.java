package src.Actions;

import javax.swing.*;
import java.awt.event.*;
import src.Utils.StatusCode;

public class MenuItemAction extends JMenu implements ActionListener {
    public MenuItemAction() { }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("About XML Editor")) {
            aboutAction(e);
        } else if (e.getActionCommand().equals("Quit (Control + Q)")) {
            exitAction(e);
        }
    }

    private void aboutAction(ActionEvent e) {
        String message = "Hello World! This is a simple XML Editor.";
        JOptionPane.showMessageDialog(null, message);
    }

    private void exitAction(ActionEvent e) {
        System.exit(StatusCode.EXIT);
    }
}
