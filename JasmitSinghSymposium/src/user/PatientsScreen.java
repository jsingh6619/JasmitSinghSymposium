//text label line 95 is where the text is drawn. need to overide it so it checks the string for \n and if there is, starts a new line  -  i have no idea how to do that

package user;

import java.io.File;
import java.util.*;

import abstractClasses.*;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import main.Main;

public class PatientsScreen extends AbstractScreen {

	private ArrayList<String> patientNames;
	public static ScrollablePane scroll;
	private int patients;
	public String file;

	public PatientsScreen(int width, int height) {
		super(width, height);
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		setBackground(getA());
		
		scroll = new ScrollablePane(this, 35, 39, 443, 275);
		populateScroll();
		viewObjects.add(scroll);
		
		file = "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + ".txt";
		patientNames = new ArrayList<String>();
		patients = numberOfPatients();
	}
	
	//needs a counter to keep track of row number , if there are 4 patients, satrt new row
	private void populateScroll() {
		scroll.removeAll();
		int row = 0;
		for(int i = 0; i < patients; i++) {
			int x = i;
			scroll.addObject(new Button(350 + 150*i, 300, 100, 100, patientNames.get(i) + readLine(1,"resources/" +  Main.getDoctor() + "/patients/" + patientNames.get(i)), getB(), new Action() {
				public void act() {
					Main.setPatient(patientNames.get(x));
					Main.main.setScreen(new UserInfoScreen(getWidth(), getHeight()));
				}
			}));
			AbstractButton.circleButton(user);
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
