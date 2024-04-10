package src.Modes;

import java.awt.*;
import java.awt.event.*;

public class ClassMode extends Mode {
    public ClassMode() {
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("x:" + e.getX() + "  y: " + e.getY());
        Shape obj = new ClassObj(e.getX(), e.getY(), "Class");
        canvas.addShape(obj);
    }
}
