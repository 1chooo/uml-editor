package src.Components;

import javax.swing.JPanel;
import java.awt.Color;

public class Canvas extends JPanel {
    private volatile static Canvas instance = null;

    public Canvas() {
        setBackground(Color.LIGHT_GRAY);
    }

    public static Canvas GetInstance() {
        if (instance == null)
            synchronized (Canvas.class) {
                if (instance == null)
                    instance = new Canvas();
            }
        return instance;
    }
}
