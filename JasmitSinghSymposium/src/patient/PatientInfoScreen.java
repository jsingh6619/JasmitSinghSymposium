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
	
		//for patient basic info
		
		Button back = new Button(100, 50, 540, 200, "", getD(), new Action() {
			public void act() {
			}
		});
		backButton(back);
		
		drawTextArea(new TextArea(115, 50, 400, 225, Main.getPatient()), 36);
		drawTextArea(new TextArea(115, 106, 400, 225, readLine(1,file)), 24);
		drawTextArea(new TextArea(115, 188, 400, 225, readLine(2,file)), 18);
		drawTextArea(new TextArea(115, 150, 400, 225, readLine(3,file)), 18);
		
		//for patient insurance info
		
		Button insurBank = new Button(690, 50, 350, 200, "", getH(), new Action() {
			public void act() {
			}
		});
		backButton(insurBank);
		
		//for the rest of the info
		
		drawTextArea(new TextArea(705, 50, 400, 225, readLine(5,file)), 34);
		drawTextArea(new TextArea(705, 106, 400, 225, readLine(6,file)), 24);
		drawTextArea(new TextArea(705, 188, 400, 225, readLine(7,file)), 18);
		drawTextArea(new TextArea(705, 150, 400, 225, readLine(8,file)), 18);
		drawTextArea(new TextArea(100, 250, 450, 50, "Family History"), 25, Color.WHITE);
		drawTextArea(new TextArea(100, 460, 450, 50, "Allergies"), 25, Color.WHITE);
		
		famHist = new ScrollablePane(this, 100, 300, 450, 160);
		famHist.setBackground(getB());
		populateScroll(4);
		
		allergies = new ScrollablePane(this, 100, 510, 450, 160);
		allergies.setBackground(getE());
		populateScroll(5);
		
		viewObjects.add(famHist); 
		viewObjects.add(allergies);
		
		Button notes = new Button(600, 550, 125, 125, "Notes", getG(), new Action() {
			public void act() {
				Main.main.setScreen(new HistoryScreen(getWidth(), getHeight()));
			}
		});
		notes.setSize(20);
		
		Button prescripitions = new Button(715, 275, 157, 157, "Prescriptions", getC(), new Action() {
			public void act() {
				PatientInfoScreen.popper = 2;
				PatientInfoScreen.head = "Prescriptions";
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		prescripitions.setSize(20);
		
		Button immunizations = new Button(1000, 250, 142, 142, "Immunizations", getJ(), new Action() {
			public void act() {
				PatientInfoScreen.popper = 3;
				PatientInfoScreen.head = "Immunizations";
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		immunizations.setSize(20);
	
		Button update = new Button(1100, 100, 100, 100, "Update", getI(), new Action() {
			public void act() {
				PatientInfoScreen.popper = 4;
				PatientInfoScreen.head = "     Update     ";
				Main.main.setScreen(new UpdateScreen(getWidth(), getHeight()));
			}
		});
		update.setSize(20);
	
		AbstractButton.circleButton(notes);
		AbstractButton.circleButton(prescripitions);
		AbstractButton.circleButton(immunizations);
		AbstractButton.circleButton(update);
		
		viewObjects.add(notes);
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
		
		//prescriptions
		if(condition == 2) {
			drawTextArea(new TextArea(15, 0, 180, 45, "Rx No."), 24, popped);
			drawTextArea(new TextArea(195, 0, 180, 45, "Dosage"), 24, popped);
			drawTextArea(new TextArea(370, 0, 180, 45, "Date Begin"), 24, popped);
			drawTextArea(new TextArea(550, 0, 180, 45, "Date End"), 24, popped);
			drawTextArea(new TextArea(730, 0, 180, 45, "Prescriber"), 24, popped);
			
			int row = 0;
			for(int i = 1; i < maxLines("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/prescription") + 1; i++) {
				int xAlign = i % 5;
				if(xAlign == 1) {
					xAlign = 15;
				}
				if(xAlign == 2) {
					xAlign = 195;
				}
				if(xAlign == 3) {
					xAlign = 370;
				}
				if(xAlign == 4) {
					xAlign = 550;
				}
				if(xAlign == 0) {
					xAlign = 730;
				}
				
				drawTextArea(new TextArea(xAlign, (row * 20) + 40, 340, 45, readLine(i, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/prescription")), 18, popped);
				
				if(i % 5 == 0) {
					row += 2;
				}
			}
			
			popped.update();
		}
		
		//immunizations
		if(condition == 3) {
			drawTextArea(new TextArea(15, 0, 160, 45, "Vaccine"), 24, popped);
			drawTextArea(new TextArea(175, 0, 205, 45, "Manufacturer"), 24, popped);
			drawTextArea(new TextArea(405, 0, 100, 45, "Lot"), 24, popped);
			drawTextArea(new TextArea(505, 0, 110, 45, "Dosage"), 24, popped);
			drawTextArea(new TextArea(615, 0, 125, 45, "Date"), 24, popped);
			drawTextArea(new TextArea(740, 0, 180, 45, "Administrator"), 24, popped);
			
			int row = 0;
			for(int i = 1; i < maxLines("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/immunizations") + 1; i++) {
				int xAlign = i % 6;
				if(xAlign == 1) {
					xAlign = 15;
				}
				if(xAlign == 2) {
					xAlign = 175;
				}
				if(xAlign == 3) {
					xAlign = 405;
				}
				if(xAlign == 4) {
					xAlign = 505;
				}
				if(xAlign == 5) {
					xAlign = 615;
				}
				if(xAlign == 0) {
					xAlign = 740;
				}
				
				drawTextArea(new TextArea(xAlign, (row * 20) + 40, 340, 45, readLine(i, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/immunizations")), 18, popped);

				if(i % 6 == 0) {
					row += 2;
				}
			}
			popped.update();
		}
		
		//famHist
		if(condition == 4) {
			for(int i = 1; i < maxLines("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/health") + 1; i++) {
				drawTextArea(new TextArea(10, 25*(i-1), 340, 45, readLine(i, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/health")), 24, famHist);
			}
			if(readLine(1, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/health") == null){
				drawTextArea(new TextArea(10, 0, 340, 45, "NONE"), 24, famHist);
			}
			famHist.update();
		}
		
		//alergies
		if(condition == 5) {
			for(int i = 1; i < maxLines("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/allergies") + 1; i++) {
				drawTextArea(new TextArea(10, 25*(i-1), 340, 45, readLine(i, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/allergies")), 24, allergies);
			}
			if(readLine(1, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/allergies") == null){
				drawTextArea(new TextArea(10, 0, 340, 45, "NONE"), 24, allergies);
			}
			allergies.update();
		}
	}
	
	public void createPopup(String head, int x) {
		Button leftExit = new Button(0, 0, 150, 720, "", getA(), new Action() {
			
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
		
		Button bottomExit = new Button(0, 635, 1280, 85, "", getA(), new Action() {
			
			public void act() {
				PatientInfoScreen.popper = 0;
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		bottomExit.enable = false;
		
		Button rightExit = new Button(1080, 0, 200, 720, "", getA(), new Action() {
			
			public void act() {
				PatientInfoScreen.popper = 0;
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		rightExit.enable = false;
		
		Button popupRightExit = new Button(1020, 0, 260, 135, "", getA(), new Action() {
			
			public void act() {
				PatientInfoScreen.popper = 0;
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		popupRightExit.enable = false;

		Button popupLeftExit = new Button(0, 0, 700, 135, "", getA(), new Action() {
	
			public void act() {
				PatientInfoScreen.popper = 0;
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		popupLeftExit.enable = false;
		
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
		getViewObjects().add(popupRightExit);
		getViewObjects().add(popupLeftExit);
		getViewObjects().add(popup);
		getViewObjects().add(title);
		getViewObjects().add(popped);
		getViewObjects().add(exit);
	}
}
