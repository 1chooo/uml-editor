package src;

import src.components.TestComponents;

public class Main {

    public static void main(String[] args) {
        // show the GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TestComponents.createAndShowGUI();
            }
        });
    }
}
