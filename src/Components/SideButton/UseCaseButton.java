package src.Components.SideButton;

import javax.swing.*;
import java.awt.event.*;
// import src.Utils.StatusCode;

public class UseCaseButton extends Button implements ActionListener  {
    private JButton useCaseButton;

    public UseCaseButton() {
        useCaseButton = createButton("Use Case");
    }

    private JButton createButton(String name) {
        JButton button;
        button = new JButton(name);
        button.addActionListener(this);

        return button;
    }

    public JButton getUseCaseButton() {
        return useCaseButton;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == useCaseButton) {
            String message = "This is Use Case button. It is clicked.";

            message = String.format(message);

            JOptionPane.showMessageDialog(null, message);
        }
    }
}
