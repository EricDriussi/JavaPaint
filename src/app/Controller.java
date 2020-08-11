package app;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class Controller {

	private JPanel drawingPanel;
	private JFileChooser fc = new JFileChooser(".");

	public Controller(JPanel draw) {
		drawingPanel = draw;

	}

	public void saveImage() {

		int returnVal = fc.showSaveDialog(drawingPanel);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();

			BufferedImage img = new BufferedImage(drawingPanel.getWidth(), drawingPanel.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = img.createGraphics();
			drawingPanel.printAll(g2d);
			g2d.dispose();

			try {
				ImageIO.write(img, "png", file);

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	public void loadImage() {

		int returnVal = fc.showOpenDialog(drawingPanel);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();

			try {
				BufferedImage myPicture = ImageIO.read(file);
				DrawingPanel.newImage = myPicture;
				drawingPanel.repaint();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
