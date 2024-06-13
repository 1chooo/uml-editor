package Components;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.BorderFactory;

import Modes.Mode;
import Shapes.Group;
import Shapes.Line;
import Shapes.Shape;

public class Canvas extends JPanel {
	public Shape selectedObject = null;
	public Line tmpLine = null;
	public Rectangle selectedArea = null;

	protected Mode currrentMode = null;

	private EventListener listener = null;
	private List<Shape> shapes = new ArrayList<Shape>();
	private List<Line> lines = new ArrayList<Line>();

	private static Canvas instance = null;

	public Canvas() {
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setPreferredSize(new Dimension(1055, 300));
	}

	public static Canvas getInstance() {
		if (instance == null)
			instance = new Canvas();
		return instance;
	}

	public List<Shape> getShapes() {
		return shapes;
	}

	public void addShape(Shape shape) {
		shapes.add(shape);
	}

	public void addLine(Line line) {
		lines.add(line);
	}

	public void changeObjName(String name) {
		if (selectedObject != null)
			selectedObject.changeName(name);
	}

	public void createGroup() {
		Group group = new Group();
		for (int i = 0; i < shapes.size(); i++) {
			Shape shape = shapes.get(i);
			if (shape.isSelected == true) {
				shape.isSelected = false;
				group.addShape(shape);
				shapes.remove(i);
				i--; // refactor
			}
		}
		group.setEdge();
		shapes.add(group);
		selectedObject = null;
	}

	public void unGroup() {
		Group group = (Group) selectedObject;
		List<Shape> inGroup = group.getShapes();
		for (int i = 0; i < inGroup.size(); i++) {
			Shape shape = inGroup.get(i);
			shapes.add(shape);
		}
		shapes.remove(selectedObject);
		selectedObject = null;
	}

	public void setCurrrentMode(Mode mode) {
		removeMouseListener((MouseListener) listener);
		removeMouseMotionListener((MouseMotionListener) listener);
		currrentMode = mode;
		listener = currrentMode;
		addMouseListener((MouseListener) listener);
		addMouseMotionListener((MouseMotionListener) listener);
	}

	public boolean withinSelectedArea(Shape shape) {
		Point top1 = new Point(shape.getX1(), shape.getY1());
		Point top2 = new Point(shape.getX2(), shape.getY1());
		Point bot1 = new Point(shape.getX1(), shape.getY2());
		Point bot2 = new Point(shape.getX2(), shape.getY2());

		return (selectedArea.contains(top1)
				&& selectedArea.contains(top2)
				&& selectedArea.contains(bot1)
				&& selectedArea.contains(bot2));
	}

	public void paint(Graphics graphics) {
		super.paint(graphics);

		Dimension dimension = getSize();
		graphics.setColor(new Color(200, 200, 200));
		graphics.fillRect(0, 0, dimension.width, dimension.height);

		graphics.setColor(new Color(0, 0, 0));
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setStroke(new BasicStroke(4));

		for (int i = shapes.size() - 1; i >= 0; i--) {
			Shape shape = shapes.get(i);
			shape.draw(graphics);
			shape.drawGroup(graphics);
			if (shape.isSelected == true)
				shape.drawPort(graphics);
		}

		graphics.setColor(new Color(0, 0, 0));
		for (int i = lines.size() - 1; i >= 0; i--) {
			Line line = lines.get(i);
			line.draw(graphics);
		}

		graphics.setColor(new Color(0, 0, 0));
		if (selectedObject != null)
			selectedObject.drawPort(graphics);

		if (tmpLine != null)
			tmpLine.draw(graphics);

		if (selectedArea != null) {
			graphics.setColor(new Color(242, 242, 242, 50));
			graphics.fillRect(
					selectedArea.x, selectedArea.y,
					selectedArea.width, selectedArea.height);
			graphics.setColor(new Color(242, 242, 242));
			graphics.drawRect(
					selectedArea.x, selectedArea.y,
					selectedArea.width, selectedArea.height);

		}
		repaint();
	}
}
