// src/Components/Menu.java

package src.Components;

import javax.swing.*;
import java.awt.event.*;
import src.Utils.StatusCode;

public class MenuBar implements ActionListener {
    private JMenuBar menuBar;
    private JMenu xmlEditor, file, edit, help;
    private JMenuItem about, quit;

    public MenuBar() {
        xmlEditor = createMenu("XML Editor");
        file = createMenu("File");
        edit = createMenu("Edit");
        help = createMenu("Help");
        
        about = createMenuItem("About XML Editor");
        quit = createMenuItem("Quit (Control + Q)");

        xmlEditor.add(about);
        xmlEditor.add(quit);

        menuBar = createMenuBar(xmlEditor, file, edit, help);
    }

    private JMenuItem createMenuItem(String name) {
        JMenuItem menuItem;
        menuItem = new JMenuItem(name);
        menuItem.addActionListener(this);

        return menuItem;
    }

    private JMenu createMenu(String name) {
        JMenu menu;
        menu = new JMenu(name);

        return menu;
    }

    private JMenuBar createMenuBar(JMenu... menus) {
        JMenuBar menuBar;
        menuBar = new JMenuBar();
        
        for (JMenu menu : menus)
            menuBar.add(menu);
        
        return menuBar;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quit)
            System.exit(StatusCode.EXIT);
        if (e.getSource() == about) {
            String message = "Hello World! This is a simple XML Editor.";

            message = String.format(message);

            JOptionPane.showMessageDialog(null, message);
        }
    }
}
