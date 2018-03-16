package user;

import java.io.File;
import java.util.*;

import abstractClasses.*;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import main.Main;

public class PatientsScreen extends AbstractScreen {

	private ArrayList<String> patientNames;
	private int patients;
	public String file;

	public PatientsScreen(int width, int height) {
		super(width, height);
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		setBackground(getA());

		file = "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + ".txt";
		patientNames = new ArrayList<String>();
		patients = numberOfPatients();

		for(int i = 0; i < patients; i++) {
			int x = i;
			Button user = new Button(350 + 150*i, 300, 100, 100, patientNames.get(i) + readLine(1), getB(), new Action() {
				public void act() {
					Main.setPatient(patientNames.get(x));
					Main.main.setScreen(new UserInfoScreen(getWidth(), getHeight()));
				}
			});
			AbstractButton.circleButton(user);
			viewObjects.add(user);
		}
	}
	
	public int numberOfPatients() {
		int numberOfUsers = 0;
		File directory = new File("resources/" +  Main.getDoctor() + "/patients");
		File listDir[] = directory.listFiles();
		for (File x : listDir) {
			if (!x.isDirectory()) {
				numberOfUsers++;
				patientNames.add(x.getName());
			}
		}
		return numberOfUsers;
	}
}
