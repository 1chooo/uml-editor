package shapes;

import java.awt.Graphics;

public class AssociationLine extends Line {

	public AssociationLine(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public void draw(Graphics g) {
		int width = 10;
		int height = 10;
		int deltaX = x2 - x1;
		int deltaY = y2 - y1;

		double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
		double xm = distance - width;
		double xn = xm;
		double ym = height;
		double yn = -height;
		double x;
		double sin = deltaY / distance;
		double cos = deltaX / distance;

		x = xm * cos - ym * sin + x1;
		ym = xm * sin + ym * cos + y1;
		xm = x;

		x = xn * cos - yn * sin + x1;
		yn = xn * sin + yn * cos + y1;
		xn = x;

		g.drawLine((int) xm, (int) ym, x2, y2);
		g.drawLine((int) xn, (int) yn, x2, y2);
		g.drawLine(x1, y1, x2, y2);
	}
}
