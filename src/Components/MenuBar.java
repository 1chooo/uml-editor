package src.Components;

import javax.swing.*;

import src.Actions.MenuItemAction;

public class MenuBar extends JMenuBar {
    // private variables
    private JMenu xmlEditor;
    private JMenu edit;
    private JMenu file;
    private JMenu help;

    // Constructor
    public MenuBar() {
        initComponents();
    }

    // private methods
    private void initComponents() {
        xmlEditor = new JMenu("XML Editor");
        xmlEditor.add(new MenuItem("About XML Editor"));
        xmlEditor.add(new MenuItem("Quit (Control + Q)"));
        add(xmlEditor);

        edit = new JMenu("Edit");
        add(edit);

        file = new JMenu("File");
        add(file);

        help = new JMenu("Help");
        add(help);
    }

    private class MenuItem extends JMenuItem {
        public MenuItem(String name) {
            super(name);
            addActionListener(new MenuItemAction());
        }
    }

}
