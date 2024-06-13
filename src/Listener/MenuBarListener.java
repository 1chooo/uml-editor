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
import Utils.Helper;

public class MenuBarListener {
    private Canvas canvas;
    private List<Shape> shapes;

    public MenuBarListener(Canvas canvas) {
        this.canvas = canvas;
    }

    public ActionListener getAboutListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                JOptionPane.showMessageDialog(null, Helper.ABOUT_UML_MESSAGE.getValue());
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
                if (canvas.selectedObject != null) {
                    new RenameObject(canvas.selectedObject.name);
                } else {
                    new Warning(
                            Helper.SELECT_OBJECT_WARNING.getValue(), 300);
                }
            }
        };
    }

    public ActionListener getGroupListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                shapes = canvas.getShapes();
                System.out.println("shapes size :" + shapes.size());
                int cnt = 0;
                for (int i = 0; i < shapes.size(); i++) {
                    Shape shape = shapes.get(i);
                    if (shape.isSelected) {
                        cnt++;
                    }
                }

                if (cnt >= 2) {
                    canvas.createGroup();
                } else {
                    new Warning(
                            Helper.GET_GROUP_WARNING.getValue(), 300);
                }
            }
        };
    }

    public ActionListener getUnGroupListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Shape shape = canvas.selectedObject;

                if (shape != null && (shape instanceof Group)) {
                    canvas.unGroup();
                } else {
                    new Warning(
                            Helper.GET_UNGROUP_WARNING.getValue(), 300);
                }
            }
        };
    }
}
