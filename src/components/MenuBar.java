package components;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import listener.MenuBarListener;
import utils.CONFIG;

public class MenuBar extends JMenuBar {

    private transient MenuBarListener menuBarListener;

    public MenuBar() {
        initialize();
    }

    private void initialize() {
        Canvas canvas = Canvas.getInstance();
        menuBarListener = new MenuBarListener(canvas);
        createUmlEditorMenu();
        createFileMenu();
        createEditMenu();
    }

    private void createUmlEditorMenu() {
        JMenu umlEditor = new JMenu(CONFIG.APP_NAME);

        JMenuItem about = new JMenuItem(CONFIG.MENU_ITEM_ABOUT);
        about.addActionListener(menuBarListener.getAboutListener());
        umlEditor.add(about);
        JMenuItem version = new JMenuItem(CONFIG.APP_VERSION);
        version.addActionListener(menuBarListener.getVersionListener());
        umlEditor.add(version);
        JMenuItem quit = new JMenuItem(CONFIG.MENU_ITEM_QUIT);
        quit.addActionListener(menuBarListener.getQuitListener());
        umlEditor.add(quit);

        this.add(umlEditor);
    }

    private void createFileMenu() {
        JMenu file = new JMenu(CONFIG.MENU_FILE);
        this.add(file);
    }

    private void createEditMenu() {
        JMenu edit = new JMenu(CONFIG.MENU_EDIT);

        JMenuItem changeObjName = new JMenuItem(CONFIG.MENU_ITEM_CHANGE_OBJ_NAME);
        changeObjName.addActionListener(menuBarListener.getChangeNameListener());
        edit.add(changeObjName);
        edit.addSeparator();

        JMenuItem group = new JMenuItem(CONFIG.MENU_ITEM_GROUP);
        group.addActionListener(menuBarListener.getGroupListener());
        edit.add(group);
        edit.addSeparator();

        JMenuItem unGroup = new JMenuItem(CONFIG.MENU_ITEM_UNGROUP);
        unGroup.addActionListener(menuBarListener.getUnGroupListener());
        edit.add(unGroup);

        this.add(edit);
    }
}
