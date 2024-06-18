package Shapes;

import Components.Canvas;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Font;
import java.awt.Polygon;

public abstract class Shape {
	protected int x1, y1, x2, y2;
	protected Font font = new Font(Font.DIALOG, Font.BOLD, 13);

	public boolean isSelected = false;
	public String name;
	public Canvas canvas = Canvas.getInstance();

	public int getX1() {
		return this.x1;
	}

	public int getX2() {
		return this.x2;
	}

	public int getY1() {
		return this.y1;
	}

	public int getY2() {
		return this.y2;
	}

	public abstract void draw(Graphics g);

	public void drawPort(Graphics g) {
	};

	public Port getPort(int index) {
		return null;
	}

	public void changeName(String name) {
	};

	public void setLocation(Point mouse, Point point) {
	};

	public void setLocation() {
	};

	public void drawGroup(Graphics g) {
	};

	public Shape getSelectedObject() {
		return null;
	};

	public int isInside(Point p) {
		Point c = new Point();
		c.x = (x1 + x2) / 2;
		c.y = (y1 + y2) / 2;
		Point[] points = {
				new Point(x1, y1), new Point(x2, y1),
				new Point(x2, y2), new Point(x1, y2) };
		for (int i = 0; i < points.length; i++) {
			Polygon polygon = new Polygon();
			int next = ((i + 1) % 4);
			polygon.addPoint(points[i].x, points[i].y);
			polygon.addPoint(points[next].x, points[next].y);
			polygon.addPoint(c.x, c.y);
			if (polygon.contains(p))
				return i;
		}
		return -1;
	}
}
