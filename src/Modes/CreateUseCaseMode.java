package src.Modes;

import java.awt.event.MouseEvent;

import src.UmlShape.Shape;
import src.UmlShape.UseCaseObj;

public class CreateUseCaseMode extends Mode {
	/*
	 * public CreateUseCaseMode()
	 * {
	 * 
	 * }
	 */

	public void mousePressed(MouseEvent e) {
		System.out.println("x:" + e.getX() + "  y: " + e.getY());
		Shape obj = new UseCaseObj(e.getX(), e.getY(), "Use Case");
		canvas.addShape(obj);
	}
}
