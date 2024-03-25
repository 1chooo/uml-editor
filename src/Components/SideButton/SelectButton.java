package src.Components.SideButton;

import javax.swing.*;
import java.awt.event.*;
// import src.Utils.StatusCode;

public class SelectButton extends Button implements ActionListener  {
    private JButton selectButton;

    public SelectButton() {
        selectButton = createButton("Select");
    }

    private JButton createButton(String name) {
        JButton button;
        button = new JButton(name);
        button.addActionListener(this);

        return button;
    }

    public JButton getSelectButton() {
        return selectButton;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectButton) {
            String message = "This is select button. It is clicked.";

            message = String.format(message);

            JOptionPane.showMessageDialog(null, message);
        }
    }
}
