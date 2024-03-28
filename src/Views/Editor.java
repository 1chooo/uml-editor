// src/Views/Editor.java

package src.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import src.Components.MenuBar;
import src.Components.SidePanel;
import src.Utils.StatusCode;

public class Editor extends JFrame {
    private int width = 1280;
    private int height = 720;

    public Editor() {
        super("XML Editor");

        initComponents();

        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Enroll the Keyboard Listener
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

    private void initComponents() {
        setLayout(new BorderLayout());

        JMenuBar menuBar = new MenuBar();
        add(menuBar, BorderLayout.NORTH);

        JPanel sidePanel = new SidePanel();
        add(sidePanel, BorderLayout.WEST);
    }

}
