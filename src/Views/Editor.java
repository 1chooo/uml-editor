// src/Views/Editor.java

package src.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.Components.Menu;

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
                    dispose(); // Close the window
                }
                return false;
            }
        });
    }

    private void initComponents() {
        Menu menu;

        labelQuestion = new JLabel("How much water should I drink?");
        labelWeight = new JLabel("My weight (kg):");
        fieldWeight = new JTextField(5);
        buttonTellMe = new JButton("Tell Me");
        menu = new Menu();

        setLayout(new BorderLayout());

        add(menu.getMenuBar(), BorderLayout.NORTH);

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
