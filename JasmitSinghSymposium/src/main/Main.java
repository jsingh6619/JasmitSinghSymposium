package main;

import abstractClasses.MainScreen;
import guiTeacher.GUIApplication;

public class Main extends GUIApplication {

	public static Main main;
	public static LoadScreen loadScreen;

	
	public Main(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void initScreen() {
		loadScreen = new LoadScreen(getWidth(), getHeight());
		setScreen(loadScreen);
	}

	public static void main(String[] args) {
		main = new Main(1280, 720);
		Thread runner = new Thread(main);
		runner.start();
	}

}
