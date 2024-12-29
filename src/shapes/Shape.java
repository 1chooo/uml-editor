package shapes;

import java.awt.Graphics;
import java.awt.Point;

import components.Canvas;

import java.awt.Font;

public abstract class Shape {
	protected int x1;
	protected int y1;
	protected int x2;
	protected int y2;
	protected Font font = new Font(Font.DIALOG, Font.BOLD, 13);

	private boolean isSelected = false;
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

	public boolean isSelected() {
		return this.isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public abstract void draw(Graphics g);

	public abstract int isInside(Point p);

	public void drawPort(Graphics g) {
	}

	public Port getPort(int index) {
		return null;
	}

	public void changeName(String name) {
	}

	public void setLocation(Point mouse, Point point) {
	}

	public void setLocation() {
	}

	public void drawGroup(Graphics g) {
	}

	public Shape getSelectedObject() {
		return null;
	}
}
