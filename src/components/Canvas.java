package components;

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

import modes.Mode;
import shapes.Group;
import shapes.Line;
import shapes.Shape;

public class Canvas extends JPanel {
	private transient Shape selectedObject = null;
	public transient Line tmpLine = null;
	private Rectangle selectedArea = new Rectangle();

	public Shape getSelectedObject() {
		return selectedObject;
	}

	public void setSelectedObject(Shape selectedObject) {
		this.selectedObject = selectedObject;
	}


	public Rectangle getSelectedArea() {
		return selectedArea;
	}

	public Rectangle setSelectedArea(Rectangle selectedArea) {
		this.selectedArea = selectedArea;
		return selectedArea;
	}

	protected transient Mode currrentMode = null;

	private transient EventListener listener = null;
	private transient List<Shape> shapes = new ArrayList<>();
	private transient List<Line> lines = new ArrayList<>();

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

	public void createGroup() {
		Group group = new Group();
		List<Shape> selectedShapes = new ArrayList<>();

		// Traverse all Shape objects to find the selected ones at first
		for (Shape shape : shapes)
			if (shape.isSelected)
				selectedShapes.add(shape);

		for (Shape shape : selectedShapes) {
			shape.isSelected = false;
			group.addShape(shape);
			shapes.remove(shape);
		}

		group.setEdge();
		shapes.add(group);
		selectedObject = null;
	}

	public void unGroup() {
		Group group = (Group) selectedObject;
		List<Shape> inGroup = group.getShapes();

		shapes.addAll(inGroup);
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
		Point bottom1 = new Point(shape.getX1(), shape.getY2());
		Point bottom2 = new Point(shape.getX2(), shape.getY2());

		return (selectedArea.contains(top1)
				&& selectedArea.contains(top2)
				&& selectedArea.contains(bottom1)
				&& selectedArea.contains(bottom2));
	}

	// TODO: Separate paint method into multiple methods
	@Override
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
			if (shape.isSelected)
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
