// src/Views/Editor.java

package src.Views;

import javax.swing.*;
import java.awt.*;

import src.Components.MenuBar;
import src.Components.ModeStatus;
import src.Components.SidePanel;
import src.Components.Canvas;
import src.Utils.KeyboardListener;

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
