package src.Components;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;

public class SidePanel extends JPanel {
    // constructor
    public SidePanel() {
        initComponents();
    }

    // private methods
    private void initComponents() {
        setLayout(new GridLayout(0, 1)); // Set GridLayout with 1 row and multiple columns

        add(new SideButton("Select", "imgs/select.png"));
        add(new SideButton("Association Line", "imgs/association-line.png"));
        add(new SideButton("Generation Line", "imgs/generation-line.png"));
        add(new SideButton("Composition Line", "imgs/composition-line.png"));
        add(new SideButton("Class", "imgs/class.png"));
        add(new SideButton("Use Case", "imgs/use-case.png"));
    }

    // private class
    private class SideButton extends JButton {
        // private variables
        private int width = 120;
        private int height = 80;

        // constructor
        public SideButton(String name, String imgPath) {
            super(new ImageIcon(imgPath));
            
            setPreferredSize(new Dimension(width, height));
            addActionListener(e -> actionListener());
        }

        private void actionListener() {
            JOptionPane.showMessageDialog(null, "You clicked the button.");
            setBackground(Color.BLACK);
        }
    }
}