package Components;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import Modes.Mode;
import Shapes.Group;
import Shapes.Line;
import Shapes.Shape;

public class Canvas extends JPanel {

	private static Canvas instance = null;

	private EventListener listener = null;
	protected Mode curMode = null;

	public Shape selectedObj = null;
	public Line tmpLine = null;

	public Rectangle selectedArea = null;
	private List<Shape> shapes = new ArrayList<Shape>();
	private List<Line> lines = new ArrayList<Line>();

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
		if (selectedObj != null)
			selectedObj.changeName(name);
	}

	public void createGroup() {
		Group group = new Group();
		for (int i = 0; i < shapes.size(); i++) {
			Shape shape = shapes.get(i);
			if (shape.isSelected == true) {
				shape.isSelected = false;
				group.addShape(shape);
				shapes.remove(i);
				i--;
			}
		}
		group.setEdge();
		shapes.add(group);
		selectedObj = null;
	}

	public void unGroup() {
		Group group = (Group) selectedObj;
		List<Shape> inGroup = group.getShapes();
		for (int i = 0; i < inGroup.size(); i++) {
			Shape shape = inGroup.get(i);
			shapes.add(shape);
		}
		shapes.remove(selectedObj);
		selectedObj = null;
	}

	public void setCurMode(Mode mode) {
		removeMouseListener((MouseListener) listener);
		removeMouseMotionListener((MouseMotionListener) listener);
		curMode = mode;
		listener = curMode;
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
		if (selectedObj != null)
			selectedObj.drawPort(graphics);

		if (tmpLine != null)
			tmpLine.draw(graphics);

		if (selectedArea != null) {
			graphics.setColor(new Color(242, 242, 242, 50));
			graphics.fillRect(selectedArea.x, selectedArea.y,
					selectedArea.width, selectedArea.height);
			graphics.setColor(new Color(242, 242, 242));
			graphics.drawRect(selectedArea.x, selectedArea.y,
					selectedArea.width, selectedArea.height);

		}
		repaint();
	}
}
