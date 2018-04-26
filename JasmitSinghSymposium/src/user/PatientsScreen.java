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

	private ArrayList<String> patientNames;
	public String name;
	public String birthday;
	public static TextField nameInput;
	public static TextField birthdayInput;
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
		
		Button search = new Button(1025, 225, 50, 50, "Search", getA(), new Action() {
			
			public void act() {
				name = nameInput.getText().toString().toLowerCase();
				name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
				birthday = birthdayInput.getText().toString();
				
				
				//filler code -> need to make the if condition
				if(birthday.length()==0) {
					
				}
				else {
					scroll.removeAll();
					TextArea error = new TextArea(50, 125, 920, 520, "NO SUCH PATIENT");
					error.setCustomTextColor(Color.RED);
					error.setSize(36);
				}
			}
		});
		
		viewObjects.add(search);

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
