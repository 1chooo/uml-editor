package Modes;

import java.awt.event.MouseEvent;

import Shapes.ClassObject;
import Shapes.Shape;
import Shapes.UseCaseObject;

import Utils.MODES;

public class CreateShapeMode extends Mode {
    private String shapeMode;

    public CreateShapeMode(String shapeMode) {
        this.shapeMode = shapeMode;
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("x: " + e.getX() + "  y: " + e.getY());
        Shape object = null;

        switch (shapeMode) {
            case MODES.CLASS:
                object = new ClassObject(e.getX(), e.getY(),  MODES.CLASS);
                break;
            case MODES.USE_CASE:
                object = new UseCaseObject(e.getX(), e.getY(),  MODES.USE_CASE);
                break;
            default:
                System.out.println("Unsupported shape type");
                break;
        }
        if (object != null)
            canvas.addShape(object);
    }
}
