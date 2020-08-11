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
	static float currentTrans = 1.0f;
	static float currentStroke = 10.0f;

	static Color strokeColor = Color.BLACK, fillColor = Color.BLACK;

	private JPanel drawingPanel;
	private JPanel buttonPanel;
	private Controller con;

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

	public JPanel getDrawingPanel() {
		return drawingPanel;
	}

	public void setDrawingPanel(JPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	public void setButtonPanel(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	public Controller getCon() {
		return con;
	}

	public void setCon(Controller con) {
		this.con = con;
	}
	
		

}
