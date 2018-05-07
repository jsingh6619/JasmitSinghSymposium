package patient;

import java.awt.Color;
import java.util.List;

import abstractClasses.AbstractButton;
import abstractClasses.AbstractScreen;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ScrollablePane;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import main.Main;
import user.AboutScreen;
import user.PatientsScreen;

public class PatientInfoScreen extends AbstractScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String file;
	public static String head;
	public static ScrollablePane famHist;
	public static ScrollablePane allergies;
	public static ScrollablePane popped;
	public static int popper = 0;
	
	public PatientInfoScreen(int width, int height) {
		super(width, height);
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		super.initAllObjects(viewObjects);
		file = "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient();
	
		Button back = new Button(100, 50, 540, 200, "", getD(), new Action() {
			public void act() {
			}
		});
		back.setEnabled(false);
		
		TextArea name = new TextArea(115, 50, 400, 225, Main.getPatient());
		name.setSize(36);
		
		TextArea dob = new TextArea(115, 106, 400, 225, readLine(1,file));
		dob.setSize(24);
		
		TextArea number = new TextArea(115, 188, 400, 225, readLine(2,file));
		number.setSize(18);
		
		TextArea gender = new TextArea(115, 150, 400, 225, readLine(8,file));
		gender.setSize(18);
		
		viewObjects.add(back);
		viewObjects.add(name);
		viewObjects.add(dob);
		viewObjects.add(number);
		viewObjects.add(gender);
		
		famHist = new ScrollablePane(this, 100, 300, 450, 160);
		famHist.setBackground(getD());
		populateScroll(6);
		
		allergies = new ScrollablePane(this, 100, 510, 450, 160);
		allergies.setBackground(getE());
		populateScroll(7);
		
		viewObjects.add(famHist);
		viewObjects.add(allergies);
		
		Button visits = new Button(225, 203, 185, 185, "Visits", getG(), new Action() {
			public void act() {
				PatientInfoScreen.popper = 1;
				PatientInfoScreen.head = "Visits";
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		visits.setSize(20);
		
		Button history = new Button(275, 203, 185, 185, "History", getG(), new Action() {
			public void act() {
				PatientInfoScreen.popper = 2;
				PatientInfoScreen.head = "History";
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		history.setSize(20);
		
		Button prescripitions = new Button(325, 203, 185, 185, "Prescriptions", getG(), new Action() {
			public void act() {
				PatientInfoScreen.popper = 3;
				PatientInfoScreen.head = "Prescriptions";
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		prescripitions.setSize(20);
		
		Button immunizations = new Button(375, 203, 185, 185, "Immunizations", getG(), new Action() {
			public void act() {
				PatientInfoScreen.popper = 4;
				PatientInfoScreen.head = "Immunizations";
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		immunizations.setSize(20);
	
		Button update = new Button(425, 203, 185, 185, "Update", getG(), new Action() {
			public void act() {
				PatientInfoScreen.popper = 5;
				PatientInfoScreen.head = "Update";
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		update.setSize(20);
	
		AbstractButton.circleButton(visits);
		AbstractButton.circleButton(history);
		AbstractButton.circleButton(prescripitions);
		AbstractButton.circleButton(immunizations);
		AbstractButton.circleButton(update);
		
		viewObjects.add(visits);
		viewObjects.add(history);
		viewObjects.add(prescripitions);
		viewObjects.add(immunizations);
		viewObjects.add(update);
		
		if(popper != 0) {
			createPopup(head, popper);
		}
	}

	public void populateScroll(int condition) {
		//visits
		if(condition == 1) {
			
		}
		
		//history
		if(condition == 2) {
			
		}
		
		//prescriptions
		if(condition == 3) {
			
		}
		
		//immunizations
		if(condition == 4) {
			
		}

		//update
		if(condition == 5) {
			
		}
		
		//famHist
		if(condition == 6) {
			
		}
		
		//alergies
		if(condition == 7) {
			
		}
	}
	
	public void createPopup(String head, int x) {
		Button leftExit = new Button(0, 0, 480, 720, "", getA(), new Action() {
			
			public void act() {
				PatientInfoScreen.popper = 0;
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		leftExit.enable = false;
		
		Button topExit = new Button(0, 0, 1280, 50, "", getA(), new Action() {
			
			public void act() {
				PatientInfoScreen.popper = 0;
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		topExit.enable = false;
		
		Button bottomExit = new Button(0, 650, 1280, 70, "", getA(), new Action() {
			
			public void act() {
				PatientInfoScreen.popper = 0;
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		bottomExit.enable = false;
		
		Button rightExit = new Button(800, 0, 480, 720, "", getA(), new Action() {
			
			public void act() {
				PatientInfoScreen.popper = 0;
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		rightExit.enable = false;
		
		getViewObjects().removeAll(getViewObjects());

		Button popup = new Button(480, 50, 320, 600, "", getC(), new Action() {
			public void act() {
			}
		});
		popup.setEnabled(false);
					
		TextLabel title = new TextLabel(540, 75, 200, 125, head);
		title.setSize(35);
		
		popped = new ScrollablePane(this, 500, 135, 280, 500);
		popped.setBackground(new Color(108, 195, 252));
		populateScroll(x);
		
		Button exit = new Button(750, 50, 50, 50, "x", popped.getBackground(), new Action() {
			
			public void act() {
				PatientInfoScreen.popper = 0;
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		exit.setSize(20);
		
		getViewObjects().add(leftExit);
		getViewObjects().add(topExit);
		getViewObjects().add(bottomExit);
		getViewObjects().add(rightExit);
		getViewObjects().add(popup);
		getViewObjects().add(title);
		getViewObjects().add(popped);
		getViewObjects().add(exit);
	}
}
