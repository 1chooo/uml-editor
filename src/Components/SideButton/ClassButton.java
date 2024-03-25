package src.Components.SideButton;

import javax.swing.*;
import java.awt.event.*;
// import src.Utils.StatusCode;

public class ClassButton extends Button implements ActionListener  {
    private JButton classButton;

    public ClassButton() {
        classButton = createButton("Class");
    }

    private JButton createButton(String name) {
        JButton button;
        button = new JButton(name);
        button.addActionListener(this);

        return button;
    }

    public JButton getClassButton() {
        return classButton;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == classButton) {
            String message = "This is Class button. It is clicked.";

            message = String.format(message);

            JOptionPane.showMessageDialog(null, message);
        }
    }
}
