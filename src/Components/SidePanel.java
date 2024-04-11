package src.Components;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import src.Modes.Mode;
import src.Modes.SelectMode;
import src.Modes.CreateLineMode;
import src.Modes.CreateClassMode;
import src.Modes.CreateUseCaseMode;
import src.Components.Canvas;

public class SidePanel extends JToolBar {

    private JButton curBtn = null;
    private Canvas canvas;
    private Mode mode;

    // constructor
    public SidePanel() {
        initComponents();
    }

    // private methods
    private void initComponents() {
        setLayout(new GridLayout(0, 1)); // Set GridLayout with 1 row and multiple columns

        mode = new SelectMode();
        JButton selectBtn = setButton("Select", "imgs/select.png", mode);
        this.add(selectBtn);

        mode = new CreateLineMode("AssociationLine");
        JButton associationBtn = setButton("<html>Association<br>Line</html>", "imgs/association-line.png",
                mode);
        this.add(associationBtn);

        mode = new CreateLineMode("GeneralizationLine");
        JButton generalizationBtn = setButton("<html>Generalization<br>Line</html>", "imgs/generation-line.png",
                mode);
        this.add(generalizationBtn);

        mode = new CreateLineMode("CompositionLine");
        JButton compositionBtn = setButton("<html>Composition<br>Line</html>", "imgs/composition-line.png",
                mode);
        this.add(compositionBtn);

        mode = new CreateClassMode();
        JButton classBtn = setButton("Class", "imgs/class.png", mode);
        this.add(classBtn);

        mode = new CreateUseCaseMode();
        JButton useCaseBtn = setButton("Use Case", "imgs/use-case.png", mode);
        this.add(useCaseBtn);
    }

    private JButton setButton(String name, String imgPath, Mode m) {
        JButton Btn = new JButton();
        Btn.setFocusPainted(false);

        Btn.setLayout(new BorderLayout());
        JLabel txt = new JLabel(name, SwingConstants.CENTER);
        JLabel img = new JLabel(new ImageIcon(imgPath));
        Btn.add(img, BorderLayout.WEST);
        Btn.add(txt, BorderLayout.CENTER);

        // Btn.setToolTipText(tipTxt);
        Btn.setBackground(new java.awt.Color(255, 255, 255));

        Btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (curBtn != null)
                    curBtn.setBackground(new java.awt.Color(255, 255, 255));

                curBtn = (JButton) e.getSource();
                curBtn.setBackground(new java.awt.Color(120, 120, 120));

                canvas.setCurMode(m);
                canvas.selectedObj = null;
            }
        });

        return Btn;
    }

}