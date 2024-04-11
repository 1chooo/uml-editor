// src/Views/Editor.java

package test.src.Views;

import javax.swing.*;

import test.src.Components.Canvas;
import test.src.Components.MenuBar;
import test.src.Components.ModeStatus;
import test.src.Components.SidePanel;
import test.src.Utils.KeyboardListener;

import java.awt.*;

public class Editor extends JFrame {
    // private variables
    private int width = 1280;
    private int height = 720;

    // constructor
    public Editor() {
        super("XML Editor");

        initComponents();
    }

    // private methods
    private void initComponents() {
        setLayout(new BorderLayout());

        JMenuBar menuBar = new MenuBar();
        add(menuBar, BorderLayout.NORTH);

        JToolBar sidePanel = new SidePanel();
        add(sidePanel, BorderLayout.WEST);

        JLabel modeStatus = new ModeStatus();
        add(modeStatus, BorderLayout.SOUTH);

        JPanel canvas = Canvas.getInstance();
        add(canvas, BorderLayout.CENTER);

        KeyboardListener keyboardListener = new KeyboardListener();
        keyboardListener.registerKeyboardListener();

        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }
}
