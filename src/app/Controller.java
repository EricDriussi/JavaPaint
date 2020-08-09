package app;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Controller {

	static DrawingPanel drawingPanel;

	public Controller(DrawingPanel draw) {
		Controller.drawingPanel = draw;
	}

	public static void saveImage() {
		Container pane = Controller.drawingPanel;
		BufferedImage img = new BufferedImage(pane.getWidth(), pane.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();
		pane.printAll(g2d);
		g2d.dispose();
		try {
			ImageIO.write(img, "png", new File("nice"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
