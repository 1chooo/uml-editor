package src.Modes;

import java.awt.event.*;

import src.Shapes.ClassObj;
import src.Shapes.Shape;

public class CreateClassMode extends Mode {

	public CreateClassMode() {

	}

	public void mousePressed(MouseEvent e) {
		System.out.println("x:" + e.getX() + "  y: " + e.getY());
		Shape obj = new ClassObj(e.getX(), e.getY(), "Class");
		canvas.addShape(obj);
	}
}
