package Components;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import Listener.MenuBarListener;

public class MenuBar extends JMenuBar {

    private Canvas canvas;

    private MenuBarListener menuBarListener;

    public MenuBar() {
        initialize();
    }

    private void initialize() {
        canvas = Canvas.getInstance();
        menuBarListener = new MenuBarListener(canvas);
        createXmlEditorMenu();
        createFileMenu();
        createEditMenu();
    }

    private void createXmlEditorMenu() {
        JMenu xmlEditor = new JMenu("XML Editor");
        JMenuItem about = new JMenuItem("About XML Editor");
        about.addActionListener(menuBarListener.getAboutListener());
        xmlEditor.add(about);
        JMenuItem quit = new JMenuItem("Quit (Control + Q)");
        quit.addActionListener(menuBarListener.getQuitListener()); // Exit the application
        xmlEditor.add(quit);

        this.add(xmlEditor);
    }

    private void createFileMenu() {
        JMenu file = new JMenu("File");
        this.add(file);
    }

    private void createEditMenu() {
        JMenu edit = new JMenu("Edit");

        JMenuItem changeObjName = new JMenuItem("Change Object Name");
        changeObjName.addActionListener(menuBarListener.getChangeNameListener());
        edit.add(changeObjName);
        edit.addSeparator();

        JMenuItem group = new JMenuItem("Group");
        group.addActionListener(menuBarListener.getGroupListener());
        edit.add(group);
        edit.addSeparator();

        JMenuItem unGroup = new JMenuItem("UnGroup");
        unGroup.addActionListener(menuBarListener.getUnGroupListener());
        edit.add(unGroup);

        this.add(edit);
    }
}
