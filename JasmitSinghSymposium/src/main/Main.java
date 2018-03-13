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
	public static String doctor = "";

	public Main(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void initScreen() {
		loadScreen = new LoadScreen(getWidth(), getHeight());
		userScreen = new UserScreen(getWidth(), getHeight());
		aboutScreen = new AboutScreen(getWidth(), getHeight());
		calendarScreen = new CalendarScreen(getWidth(), getHeight());
		scheduleScreen = new ScheduleScreen(getWidth(), getHeight());
		userInfoScreen = new UserInfoScreen(getWidth(), getHeight());
		historyScreen = new HistoryScreen(getWidth(), getHeight());
		immunizationsScreen = new ImmunizationsScreen(getWidth(), getHeight());
		patientInfoScreen = new PatientInfoScreen(getWidth(), getHeight());
		patientsScreen = new PatientsScreen(getWidth(), getHeight());
		prescriptionsScreen = new PrescriptionsScreen(getWidth(), getHeight());
		visitsScreen = new VisitsScreen(getWidth(), getHeight());
		setScreen(userScreen);
	}

	public static void main(String[] args) {
		main = new Main(1280, 720);
		Thread runner = new Thread(main);
		runner.start();
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		Main.doctor = doctor;
	}
}
