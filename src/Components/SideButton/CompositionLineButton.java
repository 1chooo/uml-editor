package src.Components.SideButton;

import javax.swing.*;
import java.awt.event.*;
// import src.Utils.StatusCode;

public class CompositionLineButton extends Button implements ActionListener  {
    private JButton compositionLineButton;

    public CompositionLineButton() {
        compositionLineButton = createButton("Composition Line");
    }

    private JButton createButton(String name) {
        JButton button;
        button = new JButton(name);
        button.addActionListener(this);

        return button;
    }

    public JButton getCompositionLineButton() {
        return compositionLineButton;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compositionLineButton) {
            String message = "This is Composition Line button. It is clicked.";

            message = String.format(message);

            JOptionPane.showMessageDialog(null, message);
        }
    }
}
