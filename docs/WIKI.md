# Wiki

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
            ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0)) {
            System.exit(StatusCode.EXIT);  // Close the window
        }
        return false;
    }
});
```
