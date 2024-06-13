package Modes;

import java.awt.event.MouseEvent;

import Shapes.ClassObject;
import Shapes.Shape;
import Shapes.UseCaseObject;

public class CreateShapeMode extends Mode {
    private String shapeType;

    public CreateShapeMode(String shapeType) {
        this.shapeType = shapeType;
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("x: " + e.getX() + "  y: " + e.getY());
        Shape object = null;
        switch (shapeType) {
            // TODO: Change to enum
            case "Class":
                object = new ClassObject(e.getX(), e.getY(), "Class"); // change to enum or Action Class as aggregation
                break;
            case "Use Case":
                object = new UseCaseObject(e.getX(), e.getY(), "Use Case");
                break;
            default:
                System.out.println("Unsupported shape type");
                break;
        }
        if (object != null)
            canvas.addShape(object);
    }
}
