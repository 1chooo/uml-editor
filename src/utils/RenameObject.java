package utils;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import components.Canvas;

public class RenameObject extends JFrame {

    private Canvas canvas = Canvas.getInstance();
    private JTextField textField;
    private String objectName;

    public RenameObject(String Name) {
        super(HELPER.RENAME_MESSAGE);
        objectName = Name;
        constructGUI();
    }

    private void constructGUI() {
        getContentPane().setLayout(new BorderLayout());

        GridLayout gridLayout = new GridLayout(0, 1);
        setLayout(gridLayout);

        JPanel panel = new JPanel();

        JLabel label = new JLabel(HELPER.RENAME_PROMPT);
        panel.add(label);

        textField = new JTextField("  " + objectName + " ");
        textField.setSize(80, 60);
        textField.addActionListener(getTextFieldListener());
        panel.add(textField);

        getContentPane().add(panel);

        panel = new JPanel();

        JButton ok = new JButton("OK");
        ok.addActionListener(getTextOKListener());
        panel.add(ok);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(getTextCancelListener());
        panel.add(cancel);

        getContentPane().add(panel, BorderLayout.PAGE_END);

        setLocationRelativeTo(null);
        setSize(400, 150);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public ActionListener getTextFieldListener() {
        return ev -> onOKButtonClicked();
    }

    public ActionListener getTextOKListener() {
        return ev -> onOKButtonClicked();
    }

    public ActionListener getTextCancelListener() {
        return ev -> onCancelButtonClicked();
    }

    private void onOKButtonClicked() {
        String input = textField.getText();

        if (input.length() > 10) {
            new Warning(
                    HELPER.RENAME_LENGTH_WARNING, 400);
        } else {
            canvas.selectedObject.changeName(input);
            dispose();
        }
    }

    private void onCancelButtonClicked() {
        dispose();
    }
}
