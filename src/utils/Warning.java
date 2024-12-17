package utils;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Warning extends JFrame {

    public Warning(String hint, int width) {
        super("Warning");
        initializeUI(hint, width);
    }

    private void initializeUI(String hint, int width) {
        setupLayout();
        addComponents(hint);
        setupFrame(width);
    }

    private void setupLayout() {
        GridLayout gridLayout = new GridLayout(0, 1);
        setLayout(gridLayout);
    }

    private void addComponents(String hint) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(hint);
        panel.add(label);
        getContentPane().add(panel);

        panel = new JPanel();
        JButton ok = new JButton("OK");
        ok.addActionListener(e -> dispose());
        panel.add(ok);
        getContentPane().add(panel);
    }

    private void setupFrame(int width) {
        setLocationRelativeTo(null);
        setSize(width, 120);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
