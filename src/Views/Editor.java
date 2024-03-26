// src/Views/Editor.java

package src.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import src.Components.MenuBar;
import src.Components.SideButton.AssociationLineButton;
import src.Components.SideButton.ClassButton;
import src.Components.SideButton.CompositionLineButton;
import src.Components.SideButton.GenerationLineButton;
import src.Components.SideButton.SelectButton;
import src.Components.SideButton.UseCaseButton;
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

        SelectButton selectButton = new SelectButton();
        AssociationLineButton associationLineButton = new AssociationLineButton();
        GenerationLineButton generationLineButton = new GenerationLineButton();
        CompositionLineButton compositionLineButton = new CompositionLineButton();
        ClassButton classButton = new ClassButton();
        UseCaseButton useCaseButton = new UseCaseButton();

        // Panel for SelectButtons at the left
        JPanel selectPanel = new JPanel(new GridLayout(0, 1)); // GridLayout with 1 row and multiple columns
        selectPanel.add(selectButton.getSelectButton());
        selectPanel.add(associationLineButton.getAssociationLineButton());
        selectPanel.add(generationLineButton.getGenerationLineButton());
        selectPanel.add(compositionLineButton.getCompositionLineButton());
        selectPanel.add(classButton.getClassButton());
        selectPanel.add(useCaseButton.getUseCaseButton());
        add(selectPanel, BorderLayout.WEST);

    }

}
