package src.Components;

import javax.swing.JPanel;

public class Canvas extends JPanel {
    private volatile static Canvas instance = null;

    private Canvas() {
    }

    public static Canvas GetInstance(){
        if(instance == null)
            synchronized (Canvas.class){
                if(instance == null)
                    instance = new Canvas();
            }
        return instance;
    }
}
