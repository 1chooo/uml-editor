package src.Components.SideButton;

import javax.swing.*;
import java.awt.event.*;
// import src.Utils.StatusCode;

public class GenerationLineButton extends Button implements ActionListener  {
    private JButton generationLineButton;

    public GenerationLineButton() {
        generationLineButton = createButton("Generation Line");
    }

    private JButton createButton(String name) {
        JButton button;
        button = new JButton(name);
        button.addActionListener(this);

        return button;
    }

    public JButton getGenerationLineButton() {
        return generationLineButton;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generationLineButton) {
            String message = "This is Generation Line button. It is clicked.";

            message = String.format(message);

            JOptionPane.showMessageDialog(null, message);
        }
    }
}
