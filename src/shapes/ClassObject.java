package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class ClassObject extends BasicObject {

	public ClassObject(int x1, int y1, String name) {
		this.setWidth(100);;
		this.setHeight(120);;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = this.getWidth() + x1;
		this.y2 = this.getHeight() + y1;
		this.name = name;
		createPorts();
	}

	public void draw(Graphics g) {
		g.setColor(new Color(35, 47, 62));
		g.fillRect(x1, y1, 100, 120);

		g.setColor(new Color(0, 0, 0));
		g.drawRect(x1, y1, 100, 120);

		int split = 40;
		g.drawLine(x1, y1 + split, x2, y1 + split);
		g.drawLine(x1, y1 + split * 2, x2, y1 + split * 2);

		// set object name
		int stringWidth = g.getFontMetrics(font).stringWidth(name);
		double empty = (Math.abs(x1 - x2) - stringWidth) / 2.0;
		g.setFont(font);
		g.drawString(name, x1 + (int) empty, y1 + 25);
	}
}
