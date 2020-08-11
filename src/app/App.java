package app;

import javax.swing.JPanel;

public class App {

	public static void main(String[] args) {

		new App();

	}

	public App() {

		JPanel draw = new DrawingPanel();
		Controller con = new Controller(draw);
		
		Frame aFrame = new Frame(draw, new ButtonPanel(con), con);

		aFrame.setVisible(true);

	}

}

