## Components

### `initComponents()` Method

Once we want to initialize the components, we will use the `private` `initComponents()` method to initialize the components.


### Menu Bar

When creating a Menu Bar using the `MenuBar` class, we can add `JMenu` and `JMenuItem` components to the `JMenuBar`. To initialize these components, we use the private `initComponents()` method. Also add action listener to the `JMenuItem`.

```java
public class MenuBar extends JMenuBar {
    // private variables
    private JMenu yourMenu;

    // Constructor
    public MenuBar() {
        initComponents();
    }

    // private methods
    private void initComponents() {
        yourMenu = new JMenu("YOU MENU");
        yourMenu.add(new MenuItem("YOUR MENU ITEM 1"));
        yourMenu.add(new MenuItem("YOUR MENU ITEM 2"));
        add(yourMenu);

        ...
    }

    private class MenuItem extends JMenuItem {
        public MenuItem(String name) {
            super(name);
            addActionListener(new MenuItemAction());
        }
    }

}
```