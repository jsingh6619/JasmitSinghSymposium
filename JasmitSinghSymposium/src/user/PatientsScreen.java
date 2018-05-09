//text label line 95 is where the text is drawn. need to overide it so it checks the string for \n and if there is, starts a new line  -  i have no idea how to do that



//have a boolean to see if the screen is being accesses =from different screen
package user;

import java.awt.Color;
import java.io.File;
import java.util.*;

import abstractClasses.*;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import main.Main;
import patient.*;

public class PatientsScreen extends AbstractScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<String> patientNames;
	public String name;
	public String birthday;
	public static TextField nameInput;
	public static TextField birthdayInput;
	public static ScrollablePane scroll;
	public int patients;
	public String file;
	public static int initial = 0;
	public static int index = 0;

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
		
		//no patient found
		if(initial == 1) {
			viewObjects.remove(scroll);
			
			TextArea error = new TextArea(50, 125, 920, 520, "NO SUCH PATIENT");
			error.setCustomTextColor(Color.RED);
			error.setSize(36);
			viewObjects.add(error);
		}
		
		//patient found
		if(initial == 2) {
			viewObjects.remove(scroll);
			
			Button patient = new Button(510, 260, 205, 205, patientNames.get(index) + " " + readLine(1,"resources/" +  Main.getDoctor() + "/patients/" + patientNames.get(index) + "/info"), getF(), new Action() {
				public void act() {
					Main.setPatient(patientNames.get(index));
					Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
				}
			});
			AbstractButton.circleButton(patient);
			viewObjects.add(patient);
		}
		
		TextLabel title = new TextColoredLabel(515, 35, 155, 80, "Patients", getA(), Color.WHITE);
		title.setSize(40);
		viewObjects.add(title);
		
		TextArea nameHead = new TextArea(990, 125, 125, 100, "Name: ");
		nameHead.setCustomTextColor(Color.WHITE);
		nameHead.setSize(20);
		viewObjects.add(nameHead);
		
		nameInput = new TextField(1050, 123, 175, 35, "");
		nameInput.setSize(20);
		nameInput.setDrawBorder(false);
		viewObjects.add(nameInput);
		
		TextArea birthHead = new TextArea(990, 175, 125, 100, "D.O.B: ");
		birthHead.setCustomTextColor(Color.WHITE);
		birthHead.setSize(20);
		viewObjects.add(birthHead);
		
		birthdayInput = new TextField(1050, 173, 175, 35, "");
		birthdayInput.setSize(20);
		birthdayInput.setDrawBorder(false);
		viewObjects.add(birthdayInput);
		
		Button search = new Button(1025, 225, 75, 40, "Search", Color.WHITE, new Action() {
			public void act() {
				name = nameInput.getText().toString();
				birthday = birthdayInput.getText().toString();
				boolean found = false;
				int index = 0;
				
				for(int i = 0; i < patients; i++) {
					if(name.equals(patientNames.get(i)) && birthday.equals(readLine(1,"resources/" +  Main.getDoctor() + "/patients/" + patientNames.get(i) + "/info"))) {
						index = i;
						found = true;
						break;
					}
				};
				
				if(!found){
					PatientsScreen.initial = 1;
					Main.main.setScreen(new PatientsScreen(getWidth(), getHeight()));
				}
				
				if(found) {
					PatientsScreen.initial = 2;
					PatientsScreen.index = index;
					Main.main.setScreen(new PatientsScreen(getWidth(), getHeight()));
				}
			}
		});
		search.setSize(20);
		viewObjects.add(search);

	}
	
//one problem i am having is setting the patient correctly. I am creating the buttons within a for loop, and therefore can''t access any variables because "defined in an enclosing scope must be final or effectively final" 
	public void populateScroll() {
		scroll.removeAll();
		int row = 0;
		int col = 0;
		int rowLim = 3;
		int colLim = 3;
		for(int i = 0; i < patients; i++) {
			String str = patientNames.get(i);
			Button user = new Button(25 + 225*col, 25 + 225*row , 205, 205, patientNames.get(i) + " " + readLine(1,"resources/" +  Main.getDoctor() + "/patients/" + patientNames.get(i) + "/info"), getF(), new Action() {
				public void act() {
					Main.setPatient(str);
					Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
				}
			});
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
		scroll.update();
	}

	public int numberOfPatients() {
		int numberOfUsers = 0;
		File directory = new File("resources/" +  Main.getDoctor() + "/patients");
		File listDir[] = directory.listFiles();
		for (File x : listDir) {
			if (x.isDirectory()) {
				numberOfUsers++;
				patientNames.add(x.getName());
			}
		}
		return numberOfUsers;
	}
}
