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
        createUmlEditorMenu();
        createFileMenu();
        createEditMenu();
    }

    private void createUmlEditorMenu() {
        JMenu umlEditor = new JMenu(Config.APP_NAME);

        JMenuItem about = new JMenuItem(Config.MENU_ITEM_ABOUT);
        about.addActionListener(menuBarListener.getAboutListener());
        umlEditor.add(about);
        JMenuItem version = new JMenuItem(Config.APP_VERSION);
        version.addActionListener(menuBarListener.getVersionListener());
        umlEditor.add(version);
        JMenuItem quit = new JMenuItem(Config.MENU_ITEM_QUIT);
        quit.addActionListener(menuBarListener.getQuitListener());
        umlEditor.add(quit);

        this.add(umlEditor);
    }

    private void createFileMenu() {
        JMenu file = new JMenu(Config.MENU_FILE);
        this.add(file);
    }

    private void createEditMenu() {
        JMenu edit = new JMenu(Config.MENU_EDIT);

        JMenuItem changeObjName = new JMenuItem(Config.MENU_ITEM_CHANGE_OBJ_NAME);
        changeObjName.addActionListener(menuBarListener.getChangeNameListener());
        edit.add(changeObjName);
        edit.addSeparator();

        JMenuItem group = new JMenuItem(Config.MENU_ITEM_GROUP);
        group.addActionListener(menuBarListener.getGroupListener());
        edit.add(group);
        edit.addSeparator();

        JMenuItem unGroup = new JMenuItem(Config.MENU_ITEM_UNGROUP);
        unGroup.addActionListener(menuBarListener.getUnGroupListener());
        edit.add(unGroup);

        this.add(edit);
    }
}
