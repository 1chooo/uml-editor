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

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class MenuBarListener {
    private Canvas canvas;
    private List<Shape> shapes;

    public MenuBarListener(Canvas canvas) {
        this.canvas = canvas;
    }

    public ActionListener getAboutListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                String message = "Hi There ! This is a simple XML Editor.";
                JOptionPane.showMessageDialog(null, message);
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
                if (canvas.selectedObj != null) {
                    RenameObject dialog = new RenameObject(canvas.selectedObj.name);
                } else {
                    Warning noObj = new Warning("You must select exactly a object !", 300);
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
                    Warning lessThanTwoObj = new Warning("You must select two or more objects !", 300);
                }
            }
        };
    }

    public ActionListener getUnGroupListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Shape shape = canvas.selectedObj;

                if (shape != null && (shape instanceof Group)) {
                    canvas.unGroup();
                } else {
                    Warning nullObj = new Warning("You must select exactly a group object !", 300);
                }
            }
        };
    }
}
