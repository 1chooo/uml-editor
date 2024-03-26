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

public class Editor extends JFrame implements ActionListener {
    private int width = 1280;
    private int height = 720;

    private JLabel labelQuestion;
    private JLabel labelWeight;
    private JTextField fieldWeight;
    private JButton buttonTellMe;

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
                        ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0)) {
                    System.exit(StatusCode.EXIT);
                }
                return false;
            }
        });
    }

    private void initComponents() {
        MenuBar menu = new MenuBar();

        labelQuestion = new JLabel("How much water should I drink?");
        labelWeight = new JLabel("My weight (kg):");
        fieldWeight = new JTextField(5);
        buttonTellMe = new JButton("Tell Me");

        SelectButton selectButton = new SelectButton();
        AssociationLineButton associationLineButton = new AssociationLineButton();
        GenerationLineButton generationLineButton = new GenerationLineButton();
        CompositionLineButton compositionLineButton = new CompositionLineButton();
        ClassButton classButton = new ClassButton();
        UseCaseButton useCaseButton = new UseCaseButton();

        setLayout(new BorderLayout());

        add(menu.getMenuBar(), BorderLayout.NORTH);

        // Panel for SelectButtons at the left
        JPanel selectPanel = new JPanel(new GridLayout(0, 1)); // GridLayout with 1 row and multiple columns
        selectPanel.add(selectButton.getSelectButton());
        selectPanel.add(associationLineButton.getAssociationLineButton());
        selectPanel.add(generationLineButton.getGenerationLineButton());
        selectPanel.add(compositionLineButton.getCompositionLineButton());
        selectPanel.add(classButton.getClassButton());
        selectPanel.add(useCaseButton.getUseCaseButton());
        add(selectPanel, BorderLayout.WEST);

        JPanel contentPanel = new JPanel(); // Create a content panel
        contentPanel.setLayout(new FlowLayout()); // use FlowLayout to layout the components

        contentPanel.add(labelQuestion);
        contentPanel.add(labelWeight);
        contentPanel.add(fieldWeight);
        contentPanel.add(buttonTellMe);

        add(contentPanel, BorderLayout.CENTER); // add the content panel to the frame in the center

        buttonTellMe.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        String message = "Buddy, you should drink %.1f L of water a day!";

        float weight = Float.parseFloat(fieldWeight.getText());
        float waterAmount = calculateWaterAmount(weight);

        message = String.format(message, waterAmount);

        JOptionPane.showMessageDialog(this, message);
    }

    private float calculateWaterAmount(float weight) {
        return (weight / 10f) * 0.4f;
    }
}
