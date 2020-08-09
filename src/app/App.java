package app;

import java.awt.BorderLayout;

public class App {

	public static void main(String[] args) {

		new App();

	}

	public App() {

		Controller.drawingPanel = new DrawingPanel();

		Frame aFrame = new Frame();

		aFrame.add(new TopMenu(), BorderLayout.NORTH);
		aFrame.add(new ButtonPanel(), BorderLayout.SOUTH);
		aFrame.add(Controller.drawingPanel, BorderLayout.CENTER);
		aFrame.setVisible(true);

	}

}
