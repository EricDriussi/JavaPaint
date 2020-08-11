package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	static int currentBut = 1;

	static float transparency = 1.0f;
	static float stroke = 10.0f;

	static Color strokeColor = Color.BLACK, fillColor = Color.BLACK;

	JPanel drawingPanel;
	JPanel buttonPanel;
	Controller con;

	public Frame() {

		this.setTitle("JAVA Paint");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize.width - 600, screenSize.height - 200);
		this.setLocationRelativeTo(null);

	}

	public Frame(JPanel drawingPanel, JPanel buttonPanel, Controller con) {

		this.drawingPanel = drawingPanel;
		this.buttonPanel = buttonPanel;
		this.con = con;
		
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(drawingPanel, BorderLayout.CENTER);

		this.setTitle("JAVA Paint");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize.width - 600, screenSize.height - 200);
		this.setLocationRelativeTo(null);
	}

}
