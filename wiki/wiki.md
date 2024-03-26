# Wiki

## Actions

## Components

### `initComponents()` Method

Once we want to initialize the components, we will use the `private` `initComponents()` method to initialize the components.


### Menu Bar

When creating a Menu Bar using the `MenuBar` class, we can add `JMenu` and `JMenuItem` components to the `JMenuBar`. To initialize these components, we use the private `initComponents()` method. Also add action listener to the `JMenuItem`.

```java
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
```

## Status Code

in `src/Utils/StatusCode.java`:

```java
public class StatusCode {
    public static int OK = 200;
    public static int EXIT = 0;
}
```

## Keyboard Listener

### Exit the APP

Press `Ctrl + Q` (for Windows) or `Command + Q` (for Mac) to exit the APP.

```java
KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        // Check if the user pressed Ctrl+Q (for Windows) or Command+Q (for Mac)
        if ((e.getKeyCode() == KeyEvent.VK_Q) && 
            ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0))
            System.exit(StatusCode.EXIT);  // Close the window
        return false;
    }
});
```
