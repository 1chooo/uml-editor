package src.Components.SideButton;

import javax.swing.*;
import java.awt.event.*;
// import src.Utils.StatusCode;

public class AssociationLineButton extends Button implements ActionListener  {
    private JButton associationLineButton;

    public AssociationLineButton() {
        associationLineButton = createButton("Associational Line");
    }

    private JButton createButton(String name) {
        JButton button;
        button = new JButton(name);
        button.addActionListener(this);

        return button;
    }

    public JButton getAssociationLineButton() {
        return associationLineButton;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == associationLineButton) {
            String message = "This is Associational Line button. It is clicked.";

            message = String.format(message);

            JOptionPane.showMessageDialog(null, message);
        }
    }
}
