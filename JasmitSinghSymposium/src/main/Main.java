package main;

import guiTeacher.GUIApplication;
import patient.*;
import user.*;

public class Main extends GUIApplication {

	public static Main main;
	private static String doctor;
	private static String patient;

	public Main(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void initScreen() {
		setScreen(new UserScreen(getWidth(), getHeight()));
	}

	public static void main(String[] args) {
		main = new Main(1280, 720);
		Thread runner = new Thread(main);
		runner.start();
	}

	public static String getDoctor() {
		return doctor;
	}

	public static void setDoctor(String doctor) {
		Main.doctor = doctor;
	}

	public static String getPatient() {
		return patient;
	}

	public static void setPatient(String patient) {
		Main.patient = patient;
	}
	
}
