package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

import Components.Canvas;
import Shapes.Group;
import Shapes.Shape;
import Utils.RenameObject;
import Utils.Warning;
import Utils.HELPER;

public class MenuBarListener {
    private Canvas canvas;
    private List<Shape> shapes;

    public MenuBarListener(Canvas canvas) {
        this.canvas = canvas;
    }

    public ActionListener getAboutListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                JOptionPane.showMessageDialog(null, HELPER.ABOUT_UML_MESSAGE);
            }
        };
    }

    public ActionListener getVersionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                JOptionPane.showMessageDialog(null, HELPER.UML_VERSION_MESSAGE);
            }
        };
    }

    public ActionListener getQuitListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        };
    }

    public ActionListener getChangeNameListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                if (canvas.selectedObject != null)
                    new RenameObject(canvas.selectedObject.name);
                else
                    new Warning(HELPER.SELECT_OBJECT_WARNING, 300);
            }
        };
    }

    public ActionListener getGroupListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                shapes = canvas.getShapes();
                System.out.println("shapes size :" + shapes.size());
                int count = 0;
                for (int i = 0; i < shapes.size(); i++) {
                    Shape shape = shapes.get(i);
                    if (shape.isSelected)
                        count++;
                }

                if (count >= 2)
                    canvas.createGroup();
                else
                    new Warning(HELPER.GET_GROUP_WARNING, 300);
            }
        };
    }

    public ActionListener getUnGroupListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Shape shape = canvas.selectedObject;

                if (shape != null && (shape instanceof Group))
                    canvas.unGroup();
                else
                    new Warning(HELPER.GET_UNGROUP_WARNING, 300);
            }
        };
    }
}
