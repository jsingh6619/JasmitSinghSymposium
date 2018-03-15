package main;

import guiTeacher.GUIApplication;
import patient.*;
import user.*;

public class Main extends GUIApplication {

	public static Main main;
	public static LoadScreen loadScreen;
	public static UserScreen userScreen;
	public static AboutScreen aboutScreen;
	public static CalendarScreen calendarScreen;
	public static ScheduleScreen scheduleScreen;
	public static UserInfoScreen userInfoScreen;
	public static HistoryScreen historyScreen;
	public static ImmunizationsScreen immunizationsScreen;
	public static PatientInfoScreen patientInfoScreen;
	public static PatientsScreen patientsScreen;
	public static PrescriptionsScreen prescriptionsScreen;
	public static VisitsScreen visitsScreen;
	public static String doctor;
	public static String patient;

	public Main(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void initScreen() {
		userScreen = new UserScreen(getWidth(), getHeight());
		setScreen(userScreen);
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
}
