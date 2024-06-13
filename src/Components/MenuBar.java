package Components;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import Listener.MenuBarListener;
import Utils.Config;

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
        JMenu xmlEditor = new JMenu(Config.MENU_APP_NAME.getValue());
        JMenuItem about = new JMenuItem(Config.MENU_ITEM_ABOUT.getValue());
        about.addActionListener(menuBarListener.getAboutListener());
        xmlEditor.add(about);
        JMenuItem quit = new JMenuItem(Config.MENU_ITEM_QUIT.getValue());
        quit.addActionListener(menuBarListener.getQuitListener()); // Exit the application
        xmlEditor.add(quit);

        this.add(xmlEditor);
    }

    private void createFileMenu() {
        JMenu file = new JMenu(Config.MENU_FILE.getValue());
        this.add(file);
    }

    private void createEditMenu() {
        JMenu edit = new JMenu(Config.MENU_EDIT.getValue());

        JMenuItem changeObjName = new JMenuItem(Config.MENU_ITEM_CHANGE_OBJ_NAME.getValue());
        changeObjName.addActionListener(menuBarListener.getChangeNameListener());
        edit.add(changeObjName);
        edit.addSeparator();

        JMenuItem group = new JMenuItem(Config.MENU_ITEM_GROUP.getValue());
        group.addActionListener(menuBarListener.getGroupListener());
        edit.add(group);
        edit.addSeparator();

        JMenuItem unGroup = new JMenuItem(Config.MENU_ITEM_UNGROUP.getValue());
        unGroup.addActionListener(menuBarListener.getUnGroupListener());
        edit.add(unGroup);

        this.add(edit);
    }
}
