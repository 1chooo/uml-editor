package src.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Editor extends JFrame implements ActionListener{
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
                if ((e.getKeyCode() == KeyEvent.VK_Q) && ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0)) {
                    dispose();  // Close the window
                }
                return false;
            }
        });
    }
 
    private void initComponents() {
        labelQuestion = new JLabel("How much water should I drink?");
        labelWeight = new JLabel("My weight (kg):");
        fieldWeight = new JTextField(5);
        buttonTellMe = new JButton("Tell Me");
 
        setLayout(new FlowLayout());
 
        add(labelQuestion);
        add(labelWeight);
        add(fieldWeight);
        add(buttonTellMe);
 
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

