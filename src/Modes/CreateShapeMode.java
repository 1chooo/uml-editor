package src.Modes;

import java.awt.event.MouseEvent;
import src.Shapes.ClassObj;
import src.Shapes.Shape;
import src.Shapes.UseCaseObj;

public class CreateShapeMode extends Mode {
    private String shapeType;

    public CreateShapeMode(String shapeType) {
        this.shapeType = shapeType;
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("x: " + e.getX() + "  y: " + e.getY());
        Shape obj = null;
        switch (shapeType) {
            case "Class":
                obj = new ClassObj(e.getX(), e.getY(), "Class");
                break;
            case "Use Case":
                obj = new UseCaseObj(e.getX(), e.getY(), "Use Case");
                break;
            default:
                System.out.println("Unsupported shape type");
                break;
        }
        if (obj != null) {
            canvas.addShape(obj);
        }
    }
}
