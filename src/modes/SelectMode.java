package modes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import shapes.Shape;

import java.awt.event.MouseEvent;

public class SelectMode extends Mode {
	private List<Shape> shapes;
	private Point firstMouse;
	private int inside = -5;

	public SelectMode(String selectMode) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		firstMouse = e.getPoint();
		System.out.println("x: " + e.getX() + "  y: " + e.getY());
		shapes = canvas.getShapes();

		for (int i = 0; i < shapes.size(); i++) {
			Shape s = shapes.get(i);
			inside = s.isInside(e.getPoint());
			if (inside >= 0) {
				deselectAll();
				canvas.selectedObject = s;
				break;
			}
		}
		if (inside < 0) {
			deselectAll();
			canvas.selectedArea = new Rectangle();
		}
		canvas.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (canvas.selectedObject != null) {
			if (inside >= 0)
				canvas.selectedObject.setLocation(e.getPoint(), firstMouse);
			firstMouse = e.getPoint();
		} else {
			int left = Math.min(firstMouse.x, e.getPoint().x);
			int top = Math.min(firstMouse.y, e.getPoint().y);
			int w = Math.abs(firstMouse.x - e.getPoint().x);
			int h = Math.abs(firstMouse.y - e.getPoint().y);
			canvas.selectedArea.setBounds(left, top, w, h);

			canvas.repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (canvas.selectedObject == null) {
			int w = Math.abs(firstMouse.x - e.getPoint().x);
			int h = Math.abs(firstMouse.y - e.getPoint().y);
			canvas.selectedArea.setSize(w, h);

			System.out.println(canvas.selectedArea);
			shapes = canvas.getShapes();
			for (int i = 0; i < shapes.size(); i++) {
				Shape shape = shapes.get(i);
				if (canvas.selectedArea != null
						&& canvas.withinSelectedArea(shape))
					shape.isSelected = true;
			}
			canvas.selectedArea = null;
		}
		canvas.repaint();
	}

	private void deselectAll() {
		canvas.selectedObject = null;
		canvas.selectedArea = null;

		shapes = canvas.getShapes();
		for (int i = 0; i < shapes.size(); i++) {
			Shape shape = shapes.get(i);
			shape.isSelected = false;
		}
	}
}
