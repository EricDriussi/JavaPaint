package app;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class DrawingPanel extends JComponent implements MouseListener, MouseMotionListener {

	ArrayList<Shape> shapes = new ArrayList<>();
	ArrayList<Color> shapeFill = new ArrayList<>();
	ArrayList<Color> shapeStroke = new ArrayList<>();
	ArrayList<Float> transValues = new ArrayList<>();

	Point start, end;
	UtilPaint util = new UtilPaint();

	public DrawingPanel() {

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

	}

	@Override
	public void paint(Graphics g) {

		Graphics2D settings = (Graphics2D) g;

		settings.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		settings.setStroke(new BasicStroke(2));

		Iterator<Color> strokeCounters = shapeStroke.iterator();
		Iterator<Color> fillCounters = shapeFill.iterator();
		Iterator<Float> transCounters = transValues.iterator();

		settings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

		for (Shape s : shapes) {

			settings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transCounters.next()));

			settings.setPaint(strokeCounters.next());
			settings.draw(s);
			settings.setPaint(fillCounters.next());
			settings.fill(s);
		}

		if (start != null && end != null) {
			settings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));

			settings.setPaint(Color.GRAY);

			Shape aShape = null;

			switch (Frame.currentBut) {
			case 2:

				aShape = util.drawLine(start.x, start.y, end.x, end.y);
				break;

			case 3:

				aShape = util.drawEllipse(start.x, start.y, end.x, end.y);
				break;

			case 4:

				aShape = util.drawRectangle(start.x, start.y, end.x, end.y);
				break;
			}
			settings.draw(aShape);

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (Frame.currentBut != 1) {
			start = new Point(e.getX(), e.getY());
			end = start;
			repaint();
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (Frame.currentBut != 1) {

			Shape aShape = null;

			switch (Frame.currentBut) {

			case 2:

				aShape = util.drawLine(start.x, start.y, e.getX(), e.getY());
				break;

			case 3:

				aShape = util.drawEllipse(start.x, start.y, e.getX(), e.getY());
				break;

			case 4:

				aShape = util.drawRectangle(start.x, start.y, e.getX(), e.getY());
				break;

			}
			shapes.add(aShape);
			shapeFill.add(Frame.fillColor);
			shapeStroke.add(Frame.strokeColor);

			transValues.add(Frame.transparency);

			start = null;
			end = null;
			repaint();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (Frame.currentBut == 1) {

			Shape aShape = null;
			Frame.strokeColor = Frame.fillColor;
			aShape = util.drawBrush(e.getX(), e.getY(), Frame.stroke, Frame.stroke);

			shapes.add(aShape);
			shapeFill.add(Frame.fillColor);
			shapeStroke.add(Frame.strokeColor);

			transValues.add(Frame.transparency);
		}

		end = new Point(e.getX(), e.getY());
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
