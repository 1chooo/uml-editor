package src.Components;

import javax.swing.*;

import src.Actions.MenuItemAction;

import java.util.List;
import src.Shapes.Group;
import src.Shapes.Shape;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {
    // private variables
    private JMenu xmlEditor;
    private JMenu edit;
    private JMenu file;
    private JMenu help;

    private Canvas canvas = Canvas.getInstance();
	
	private List<Shape> shapes=null;

    // Constructor
    public MenuBar() {
        initComponents();
    }

    // private methods
    private void initComponents() {
        xmlEditor = new JMenu("XML Editor");
        xmlEditor.add(new MenuItem("About XML Editor"));
        xmlEditor.add(new MenuItem("Quit (Control + Q)"));
        add(xmlEditor);
        
        edit = new JMenu("Edit");
        JMenuItem changeObjName = new JMenuItem("Change Object Name");
		changeNameListener(changeObjName);
        edit.add(changeObjName);
        JMenuItem group = new JMenuItem("Group");
        groupListener(group);
        edit.add(group);
        JMenuItem unGroup = new JMenuItem("UnGroup");
        unGroupListener(unGroup);
        edit.add(unGroup);
        add(edit);

        file = new JMenu("File");
        add(file);

        help = new JMenu("Help");
        add(help);
    }

    private class MenuItem extends JMenuItem {
        public MenuItem(String name) {
            super(name);
            addActionListener(new MenuItemAction());
        }
    }

    public void changeNameListener(JMenuItem itemName) {
        itemName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                if (canvas.selectedObj != null) {
                    ChangeNameDialog dialog = new ChangeNameDialog(canvas.selectedObj.name);
                } else {
                    Warning noObj = new Warning("You must select exactly a object !", 300);
                }
            }
        });
    }

    public void groupListener(JMenuItem itemName) {
        itemName.addActionListener(new ActionListener() {
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
        });
    }

    public void unGroupListener(JMenuItem itemName) {
        itemName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Shape shape = canvas.selectedObj;

                if (shape != null && (shape instanceof Group)) {
                    canvas.unGroup();
                } else {
                    Warning nullObj = new Warning("You must select exactly a group object !", 300);
                }
            }
        });
    }

}
