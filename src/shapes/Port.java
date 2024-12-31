package shapes;

import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Port extends Rectangle {
	private static final Logger logger = Logger.getLogger(Port.class.getName());
	private transient List<Line> lines = new ArrayList<>();

	public void setPort(int centerX, int centerY) {
		int x = centerX - 5;
		int y = centerY - 5;
		int width = 10;
		int height = 10;

		setBounds(x, y, width, height);
	}

	public void addLine(Line line) {
		lines.add(line);
		if (logger.isLoggable(Level.INFO)) {
			logger.info(lines.toString());
		}
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
