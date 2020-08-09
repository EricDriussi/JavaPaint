package app;

import java.awt.Color;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	static int currentBut = 1;

	static float transparency = 1.0f;
	static float stroke = 10.0f;

	static Color strokeColor = Color.BLACK, fillColor = Color.BLACK;

	public Frame() {
		
		this.setSize(1000, 800);
		this.setTitle("JAVA Paint");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);

	}

}
