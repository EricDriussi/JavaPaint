package app;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener {

	ArrayList<Shape> shapeList = new ArrayList<>();
	ArrayList<Color> fillColors = new ArrayList<>();
	ArrayList<Color> strokeColors = new ArrayList<>();
	ArrayList<Float> transValues = new ArrayList<>();
	ArrayList<BasicStroke> strokeSizes = new ArrayList<>();

	Point start, end;
	UtilPaint util = new UtilPaint();

	public DrawingPanel() {

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D settings = (Graphics2D) g;

		settings.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		settings.setStroke(new BasicStroke(Frame.stroke));

		Iterator<Color> strokeColorsIte = strokeColors.iterator();
		Iterator<Color> fillColorsIte = fillColors.iterator();
		Iterator<Float> transValuesIte = transValues.iterator();
		Iterator<BasicStroke> strokeSizesIte = strokeSizes.iterator();

		settings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

		for (Shape s : shapeList) {

			settings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transValuesIte.next()));

			settings.setPaint(strokeColorsIte.next());
			settings.setStroke(strokeSizesIte.next());
			settings.draw(s);
			settings.setPaint(fillColorsIte.next());
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
			shapeList.add(aShape);
			fillColors.add(Frame.fillColor);
			strokeColors.add(Frame.strokeColor);

			strokeSizes.add(new BasicStroke(Frame.stroke));
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

			shapeList.add(aShape);
			fillColors.add(Frame.fillColor);
			strokeColors.add(Frame.strokeColor);

			strokeSizes.add(new BasicStroke(Frame.stroke));

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
