package Components;

import javax.swing.*;

import Listener.MenuBarListener;
import Shapes.Group;
import Shapes.Shape;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuBar extends JMenuBar {

    private Canvas canvas = Canvas.getInstance();

    private List<Shape> shapes = null;
    private MenuBarListener menuBarListener;

    public MenuBar() {
        initialize();
    }

    private void initialize() {
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
