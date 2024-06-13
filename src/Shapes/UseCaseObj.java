package Shapes;

import java.awt.Color;
import java.awt.Graphics;

public class UseCaseObj extends BasicObj {

	public UseCaseObj(int x1, int y1, String name) {
		this.setWidth(120);;
		this.setHeight(90);;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = this.getWidth() + x1;
		this.y2 = this.getHeight() + y1;
		this.name = name;

		createPorts();
	}

	public void draw(Graphics g) {
		g.setColor(new Color(255, 153, 0));
		g.fillOval(x1, y1, 120, 90);

		g.setColor(new Color(0, 0, 0));
		g.drawOval(x1, y1, 120, 90);

		// set obj name
		int stringWidth = g.getFontMetrics(font).stringWidth(name);
		double empty = (120 - stringWidth) / 2;
		g.setFont(font);

		g.drawString(name, x1 + (int) empty, y1 + 50);
	}
}
