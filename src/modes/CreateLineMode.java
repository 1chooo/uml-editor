package modes;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

import shapes.AssociationLine;
import shapes.CompositionLine;
import shapes.GeneralizationLine;
import shapes.Line;
import shapes.Shape;
import utils.MODES;
import java.util.logging.Logger;

public class CreateLineMode extends Mode {
	private static final Logger logger = Logger.getLogger(CreateLineMode.class.getName());

	private String lineMode;
	private List<Shape> shapes;
	private Shape shape1, shape2;
	private int port1, port2;

	private Point point1, point2;

	public CreateLineMode(String lineMode) {
		this.lineMode = lineMode;
	}

	public Line createLine(String type, Point start, Point end) {
		Line line = null;

		if (type.equals(MODES.ASSOCIATION_LINE)) {
			line = new AssociationLine(start.x, start.y, end.x, end.y);
		} else if (type.equals(MODES.GENERALIZATION_LINE)) {
			line = new GeneralizationLine(start.x, start.y, end.x, end.y);
		} else if (type.equals(MODES.COMPOSITION_LINE)) {
			line = new CompositionLine(start.x, start.y, end.x, end.y);
		} else {
			logger.warning("Unsupported Line Type");
		}
		return line;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		shapes = canvas.getShapes();
		point1 = findObject(e.getPoint(), 1);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (point1 != null) {
			Line tmpLine = createLine(lineMode, point1, e.getPoint());
			canvas.tmpLine = tmpLine;
			canvas.repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (point1 != null) {
			point2 = findObject(e.getPoint(), 2);
			if (point2 != null && shape1 != shape2) {
				Line line = createLine(lineMode, point1, point2);
				canvas.addLine(line);

				line.setPort(shape1.getPort(port1), shape2.getPort(port2));

				shape1.getPort(port1).addLine(line);
				shape2.getPort(port2).addLine(line);

			}
			canvas.tmpLine = null;
			point1 = null;
			point2 = null;
		}
	}

	public Point findObject(Point p, int tar) {
		for (int i = 0; i < shapes.size(); i++) {
			Shape shape = shapes.get(i);

			int in = shape.isInside(p);
			if (in >= 0) {
				if (in == 4) {
					shape = shape.getSelectedObject();
					in = shape.isInside(p);
				}

				if (tar == 1) {
					shape1 = shape;
					port1 = in;
				} else if (tar == 2) {
					shape2 = shape;
					port2 = in;
				}
				Point portPoint = new Point();

				portPoint.setLocation(
						shape.getPort(in).getCenterX(),
						shape.getPort(in).getCenterY());
				return portPoint;
			}
		}
		return null;
	}
}
