package src.Components;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;

public class SidePanel extends JPanel {
    // constructor
    public SidePanel() {
        initComponents();
    }

    // private methods
    private void initComponents() {
        setLayout(new GridLayout(0, 1)); // Set GridLayout with 1 row and multiple columns

        add(new SideButton("imgs/select.png"));
        add(new SideButton("imgs/association-line.png"));
        add(new SideButton("imgs/generation-line.png"));
        add(new SideButton("imgs/composition-line.png"));
        add(new SideButton("imgs/class.png"));
        add(new SideButton("imgs/use-case.png"));
    }

    // private class
    private class SideButton extends JButton {
        // constructor
        public SideButton(String imgPath) {
            super(new ImageIcon(imgPath));
            setButtonSize();
            
            addActionListener(e -> actionListener());
        }

        // private methods
        private void setButtonSize() {
            int width = getIcon().getIconWidth();
            int height = getIcon().getIconHeight();
    
            Dimension size = new Dimension(width, height);
            setPreferredSize(size);
        }

        private void actionListener() {
            JOptionPane.showMessageDialog(null, "You clicked the button.");
        }
    }
}