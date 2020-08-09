package app;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

class UtilPaint {

	Rectangle2D.Float drawRectangle(int x1, int y1, int x2, int y2) {

		int x = Math.min(x1, x2);
		int y = Math.min(y1, y2);

		int width = Math.abs(x1 - x2);
		int height = Math.abs(y1 - y2);

		return new Rectangle2D.Float(x, y, width, height);

	}

	Ellipse2D.Float drawEllipse(int x1, int y1, int x2, int y2) {

		int x = Math.min(x1, x2);
		int y = Math.min(y1, y2);

		int width = Math.abs(x1 - x2);
		int height = Math.abs(y1 - y2);

		return new Ellipse2D.Float(x, y, width, height);

	}

	Line2D.Float drawLine(int x1, int y1, int x2, int y2) {
		return new Line2D.Float(x1, y1, x2, y2);
	}

	Ellipse2D.Float drawBrush(int x1, int y1, float stokeWidth, float strokeHeight) {
		return new Ellipse2D.Float(x1, y1, stokeWidth, strokeHeight);

	}

}
