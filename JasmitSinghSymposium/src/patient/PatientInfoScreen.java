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
		file = "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/info";
	
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
		
		TextArea gender = new TextArea(115, 150, 400, 225, readLine(3,file));
		gender.setSize(18);
		
		viewObjects.add(back);
		viewObjects.add(name);
		viewObjects.add(dob);
		viewObjects.add(number);
		viewObjects.add(gender);
		
		Button insurBank = new Button(690, 50, 350, 200, "", getH(), new Action() {
			public void act() {
			}
		});
		insurBank.setEnabled(false);
		
		TextArea company = new TextArea(705, 50, 400, 225, readLine(5,file));
		company.setSize(34);
		
		TextArea id = new TextArea(705, 106, 400, 225, readLine(6,file));
		id.setSize(24);
		
		TextArea plan = new TextArea(705, 188, 400, 225, readLine(7,file));
		plan.setSize(18);
		
		TextArea contInfo = new TextArea(705, 150, 400, 225, readLine(8,file));
		contInfo.setSize(18);
		
		viewObjects.add(insurBank);
		viewObjects.add(company);
		viewObjects.add(id);
		viewObjects.add(plan);
		viewObjects.add(contInfo);
		
		TextArea hist = new TextArea(100, 250, 450, 50, "Family History");
		hist.setCustomTextColor(Color.WHITE);
		hist.setSize(25);
		
		famHist = new ScrollablePane(this, 100, 300, 450, 160);
		famHist.setBackground(getB());
		populateScroll(6);
		
		TextArea allergy = new TextArea(100, 460, 450, 50, "Allergies");
		allergy.setCustomTextColor(Color.WHITE);
		allergy.setSize(25);
		
		allergies = new ScrollablePane(this, 100, 510, 450, 160);
		allergies.setBackground(getE());
		populateScroll(7);
		
		viewObjects.add(hist);
		viewObjects.add(allergy);
		viewObjects.add(famHist);
		viewObjects.add(allergies);
		
		Button visits = new Button(575, 375, 150, 150, "Visits", getF(), new Action() {
			public void act() {
				PatientInfoScreen.popper = 1;
				PatientInfoScreen.head = "      Visits      ";
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		visits.setSize(20);
		
		Button history = new Button(600, 550, 125, 125, "History", getG(), new Action() {
			public void act() {
				PatientInfoScreen.popper = 2;
				PatientInfoScreen.head = "     History     ";
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		history.setSize(20);
		
		Button prescripitions = new Button(715, 275, 157, 157, "Prescriptions", getC(), new Action() {
			public void act() {
				PatientInfoScreen.popper = 3;
				PatientInfoScreen.head = "Prescriptions";
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		prescripitions.setSize(20);
		
		Button immunizations = new Button(1000, 250, 142, 142, "Immunizations", getJ(), new Action() {
			public void act() {
				PatientInfoScreen.popper = 4;
				PatientInfoScreen.head = "Immunizations";
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		immunizations.setSize(20);
	
		Button update = new Button(1100, 100, 100, 100, "Update", getI(), new Action() {
			public void act() {
				PatientInfoScreen.popper = 5;
				PatientInfoScreen.head = "     Update     ";
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
			popped.update();
		}
		
		//history
		if(condition == 2) {
			popped.update();
		}
		
		//prescriptions
		if(condition == 3) {
			TextArea rTitle = new TextArea(5, 0, 180, 45, "Rx No.");
			TextArea quantity = new TextArea(185, 0, 180, 45, "Quantity");
			TextArea dateBegin = new TextArea(360, 0, 180, 45, "Date Begin");
			TextArea dateEnd = new TextArea(540, 0, 180, 45, "Date End");
			TextArea docPrescriber = new TextArea(720, 0, 180, 45, "Prescriber");
			
			// fix this by having it increment by 1, and check to see the value after mod 5, to allign it how i prefer
			for(int i = 1; i < maxLines("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/prescription") + 1; i++) {
				int xAlign = i % 5;
				int row = 0;
				if(xAlign == 1) {
					xAlign = 5;
				}
				if(xAlign == 2) {
					xAlign = 185;
				}
				if(xAlign == 3) {
					xAlign = 360;
				}
				if(xAlign == 4) {
					xAlign = 540;
				}
				if(xAlign == 0) {
					xAlign = 720;
				}
				TextArea info = new TextArea(xAlign, row, 340, 45, readLine(i, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/prescription"));
				info.setSize(18);
				
				popped.addObject(info);
				if(i % 5 == 1) {
					row++;
				}
			}
			
			rTitle.setSize(24);
			quantity.setSize(24);
			dateBegin.setSize(24);
			dateEnd.setSize(24);
			docPrescriber.setSize(24);
			
			popped.addObject(rTitle);
			popped.addObject(quantity);
			popped.addObject(dateBegin);
			popped.addObject(dateEnd);
			popped.addObject(docPrescriber);
			popped.update();
		}
		
		//immunizations
		if(condition == 4) {
			popped.update();
		}

		//update
		if(condition == 5) {
			popped.update();
		}
		
		//famHist
		if(condition == 6) {
			for(int i = 1; i < maxLines("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/health") + 1; i++) {
				TextArea health = new TextArea(10, 25*(i-1), 340, 45, readLine(i, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/health"));
				health.setSize(24);
				famHist.addObject(health);
			}
			if(readLine(1, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/health") == null){
				TextArea na = new TextArea(10, 0, 340, 45, "NONE");
				na.setSize(24);
				famHist.addObject(na);
			}
			famHist.update();
		}
		
		//alergies
		if(condition == 7) {
			for(int i = 1; i < maxLines("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/allergies") + 1; i++) {
				TextArea allergy = new TextArea(10, 25*(i-1), 340, 45, readLine(i, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/allergies"));
				allergy.setSize(24);
				allergies.addObject(allergy);
			}
			if(readLine(1, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/allergies") == null){
				TextArea na = new TextArea(10, 0, 340, 45, "NONE");
				na.setSize(24);
				allergies.addObject(na);
			}
			allergies.update();
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

		Button popup = new Button(700, 50, 320, 550, "", getC(), new Action() {
			public void act() {
			}
		});
		popup.setEnabled(false);
					
		TextLabel title = new TextLabel(760, 75, 200, 125, head);
		title.setSize(35);
		
		popped = new ScrollablePane(this, 150, 135, 930, 500);
		popped.setBackground(new Color(108, 195, 252));
		populateScroll(x);
		
		Button exit = new Button(970, 50, 50, 50, "x", popped.getBackground(), new Action() {
			
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
