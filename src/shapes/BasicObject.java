package shapes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public abstract class BasicObject extends Shape {

	private int width, height;
	private int moveX, moveY;
	protected Port[] ports = new Port[4];

	public abstract void draw(Graphics g);

	public void setLocation(Point p1, Point p2) {
		moveX = p1.x - p2.x;
		moveY = p1.y - p2.y;
		this.x1 += moveX;
		this.y1 += moveY;
		this.x2 = getWidth() + x1;
		this.y2 = getHeight() + y1;

		int[] xpoint = { (x1 + x2) / 2, x2, (x1 + x2) / 2, x1 };
		int[] ypoint = { y1, (y1 + y2) / 2, y2, (y1 + y2) / 2 };

		for (int i = 0; i < ports.length; i++) {
			ports[i].setPort(xpoint[i], ypoint[i]);
			ports[i].setLine();
		}
	}

	protected void createPorts() {
		int[] xpoint = { (x1 + x2) / 2, x2, (x1 + x2) / 2, x1 };
		int[] ypoint = { y1, (y1 + y2) / 2, y2, (y1 + y2) / 2 };

		for (int i = 0; i < ports.length; i++) {
			Port p = new Port();
			p.setPort(xpoint[i], ypoint[i]);
			ports[i] = p;
		}
	}

	public void drawPort(Graphics g) {
		for (int i = 0; i < ports.length; i++)
			g.fillRect(
					ports[i].x, ports[i].y,
					ports[i].width, ports[i].height);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void changeName(String name) {
		this.name = name;
	}

	@Override
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

	@Override
	public Port getPort(int index) {
		return ports[index];
	}
}
