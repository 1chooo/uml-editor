package shapes;

import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Port extends Rectangle {

	private List<Line> lines = new ArrayList<Line>();

	public void setPort(int centerX, int centerY) {
		int x = centerX - 5;
		int y = centerY - 5;
		int width = 10;
		int height = 10;

		setBounds(x, y, width, height);
	}

	public void addLine(Line line) {
		lines.add(line);
		System.out.println(lines);
	}

	public void deleteLine(Line line) {
		lines.remove(line);
	}

	public void setLine() {
		for (int i = 0; i < lines.size(); i++) {
			Line line = lines.get(i);
			line.setLocation();
		}
	}
}
