package src.components;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestComponents {
    public static void createAndShowGUI() {
        // Ensure a consistent look and feel
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add: Hello World label
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        // Display the window
        frame.pack();
        frame.setVisible(true);
    }
}
