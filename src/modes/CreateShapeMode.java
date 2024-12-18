package modes;

import java.awt.event.MouseEvent;
import java.util.logging.Logger;

import shapes.ClassObject;
import shapes.Shape;
import shapes.UseCaseObject;
import utils.MODES;

public class CreateShapeMode extends Mode {
    private static final Logger logger = Logger.getLogger(CreateShapeMode.class.getName());
    private String shapeMode;

    public CreateShapeMode(String shapeMode) {
        this.shapeMode = shapeMode;
    }

    public void mousePressed(MouseEvent e) {
        logger.info("x: " + e.getX() + "  y: " + e.getY());
        Shape object = null;


        if(shapeMode.equals(MODES.CLASS)){
            object = new ClassObject(e.getX(), e.getY(),  MODES.CLASS);
        } else if(shapeMode.equals(MODES.USE_CASE)) {
            object = new UseCaseObject(e.getX(), e.getY(),  MODES.USE_CASE);
        } else {
            logger.warning("Unsupported shape type");
        }

        if (object != null)
            canvas.addShape(object);
    }
}
