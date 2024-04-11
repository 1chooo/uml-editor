// src/Utils/KeyboardListener.java

package test.src.Utils;

import java.awt.event.KeyEvent;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

public class KeyboardListener {
    public KeyboardListener() {    }

    public void registerKeyboardListener() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                // Check if the user pressed Ctrl+Q (for Windows) or Command+Q (for Mac)
                if ((e.getKeyCode() == KeyEvent.VK_Q) &&
                        ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0))
                    System.exit(StatusCode.EXIT);
                return false;
            }
        });
    }
}
