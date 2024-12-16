package modes;

import java.awt.event.MouseEvent;

import shapes.ClassObject;
import shapes.Shape;
import shapes.UseCaseObject;
import utils.MODES;

public class CreateShapeMode extends Mode {
    private String shapeMode;

    public CreateShapeMode(String shapeMode) {
        this.shapeMode = shapeMode;
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("x: " + e.getX() + "  y: " + e.getY());
        Shape object = null;


        if(shapeMode.equals(MODES.CLASS)){
            object = new ClassObject(e.getX(), e.getY(),  MODES.CLASS);
        } else if(shapeMode.equals(MODES.USE_CASE)) {
            object = new UseCaseObject(e.getX(), e.getY(),  MODES.USE_CASE);
        } else {
            System.out.println("Unsupported shape type");
        }

        if (object != null)
            canvas.addShape(object);
    }
}
