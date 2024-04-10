package src.Components;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;

import Modes.ClassMode;

public class SidePanel extends JPanel {
    // constructor
    public SidePanel() {
        initComponents();
    }

    // private methods
    private void initComponents() {
        setLayout(new GridLayout(0, 1)); // Set GridLayout with 1 row and multiple columns

        mode=new CreateClassMode();

        add(new SideButton("Select", "imgs/select.png"), mode);
        add(new SideButton("Association Line", "imgs/association-line.png"), mode);
        add(new SideButton("Generation Line", "imgs/generation-line.png"), mode);
        add(new SideButton("Composition Line", "imgs/composition-line.png"), mode);
        add(new SideButton("Class", "imgs/class.png"), mode);
        add(new SideButton("Use Case", "imgs/use-case.png"), mode);
    }

    // private class
    private class SideButton extends JButton {
        // private variables
        private int width = 120;
        private int height = 80;

        // constructor
        public SideButton(String name, String imgPath, Mode mode) {
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