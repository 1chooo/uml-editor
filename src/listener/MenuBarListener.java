package listener;

import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import components.Canvas;
import shapes.Group;
import shapes.Shape;
import utils.HELPER;
import utils.RenameObject;
import utils.Warning;

public class MenuBarListener {
    private static final Logger logger = Logger.getLogger(MenuBarListener.class.getName());
    private Canvas canvas;
    private List<Shape> shapes;

    public MenuBarListener(Canvas canvas) {
        this.canvas = canvas;
    }

    public ActionListener getAboutListener() {
        return ev -> JOptionPane.showMessageDialog(null, HELPER.ABOUT_UML_MESSAGE);
    }

    public ActionListener getVersionListener() {
        return ev -> JOptionPane.showMessageDialog(null, HELPER.UML_VERSION_MESSAGE);
    }

    public ActionListener getQuitListener() {
        return ev -> System.exit(0);
    }

    public ActionListener getChangeNameListener() {
        return ev -> {
            if (canvas.selectedObject != null)
                new RenameObject(canvas.selectedObject.name);
            else
                new Warning(HELPER.SELECT_OBJECT_WARNING, 300);
        };
    }

    public ActionListener getGroupListener() {
        return ev -> {
            shapes = canvas.getShapes();

            int count = 0;
            for (Shape shape : shapes) {
                if (shape.isSelected)
                    count++;
            }

            if (count >= 2) {
                canvas.createGroup();

                if (logger.isLoggable(Level.INFO)) {
                    logger.info(String.format("shapes size: %d", shapes.size()));
                }
            } else {
                new Warning(HELPER.GET_GROUP_WARNING, 300);
            }
        };
    }

    public ActionListener getUnGroupListener() {
        return ev -> {
            Shape shape = canvas.selectedObject;

            if (shape != null && (shape instanceof Group))
                canvas.unGroup();
            else
                new Warning(HELPER.GET_UNGROUP_WARNING, 300);
        };
    }
}
