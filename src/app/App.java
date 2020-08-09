package app;

import java.awt.BorderLayout;

public class App {

	public static void main(String[] args) {

		new App();

	}

	public App() {
		
		Frame aFrame = new Frame();

		aFrame.add(new ButtonPanel(), BorderLayout.SOUTH);
		aFrame.add(new DrawingPanel(), BorderLayout.CENTER);

	}

}
