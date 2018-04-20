//text label line 95 is where the text is drawn. need to overide it so it checks the string for \n and if there is, starts a new line  -  i have no idea how to do that

package user;

import java.io.File;
import java.util.*;

import abstractClasses.*;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import main.Main;
import patient.*;

public class PatientsScreen extends AbstractScreen {

	private ArrayList<String> patientNames;
	public static ScrollablePane scroll;
	private int patients;
	public String file;

	public PatientsScreen(int width, int height) {
		super(width, height);
	}
	
	//need the text area where the user types the name and date of birth, it narrows the results down
	public void initAllObjects(List<Visible> viewObjects) {
		super.initAllObjects(viewObjects);
		patientNames = new ArrayList<String>();
		patients = numberOfPatients();
		scroll = new ScrollablePane(this, 50, 125, 920, 520);
		scroll.setBackground(getA());
		populateScroll();
		viewObjects.add(scroll);
	}
	
	private void populateScroll() {
		scroll.removeAll();
		int row = 0;
		int col = 0;
		int rowLim = 3;
		int colLim = 3;
		for(int i = 0; i < patients; i++) {
			int x = 1;
			Button user = new Button(25 + 225*col, 25 + 225*row , 205, 205, patientNames.get(i) + " " + readLine(1,"resources/" +  Main.getDoctor() + "/patients/" + patientNames.get(i)), getF(), new Action() {
				public void act() {
					Main.setPatient(patientNames.get(x));
					file = "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + ".txt";
					Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
				}
			});
			System.out.println(user.getText());
			AbstractButton.circleButton(user);
			scroll.addObject(user);
			col++;
			if(i == rowLim) {
				row++;
				rowLim = rowLim + 4;
			}
			if(col > colLim) {
				col = 0;
			}
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
