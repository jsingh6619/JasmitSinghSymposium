package patient;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import abstractClasses.AbstractButton;
import abstractClasses.AbstractScreen;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import main.Main;

public class UpdateScreen extends AbstractScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextField nameChange;
	private TextField birthdayChange;
	private TextField genderChange;
	private TextField numberChange;
	private TextField insuranceCompanyChange;
	private TextField insuranceIDChange;
	private TextField insuranceNumberChange;
	private TextField insurancePlanChange;
	public static TextField allegies;
	public static TextField familyHistory;
	
	
	public UpdateScreen(int width, int height) {
		super(width, height);
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		super.initAllObjects(viewObjects);
		TextArea header = new TextArea(150, 50, 1230, 670, "What would you like to edit for " + Main.getPatient() + "?");
		header.setSize(45);
		header.setCustomTextColor(Color.WHITE);
		viewObjects.add(header);
		
		drawHead(new TextArea(150, 150, 225, 100, "Name: "));
		drawHead(new TextArea(150, 200, 225, 100, "D.O.B: "));
		drawHead(new TextArea(150, 250, 225, 100, "Gender: "));
		drawHead(new TextArea(150, 300, 225, 100, "Number: "));
		drawHead(new TextArea(150, 350, 225, 100, "Insurance Company: "));
		drawHead(new TextArea(150, 400, 225, 100, "Insurance ID: "));
		drawHead(new TextArea(150, 450, 225, 100, "Insurance Plan: "));
		drawHead(new TextArea(150, 500, 225, 100, "Insurance Number: "));
		
		nameChange = new TextField(375, 148, 175, 35, "");
		nameChange.setSize(20);
		viewObjects.add(nameChange);
		
		birthdayChange = new TextField(375, 198, 175, 35, "");
		birthdayChange.setSize(20);
		viewObjects.add(birthdayChange);
		
		genderChange = new TextField(375, 248, 175, 35, "");
		genderChange.setSize(20);
		viewObjects.add(genderChange);
		
		numberChange = new TextField(375, 298, 175, 35, "");
		numberChange.setSize(20);
		viewObjects.add(numberChange);
		
		insuranceCompanyChange = new TextField(375, 348, 175, 35, "");
		insuranceCompanyChange.setSize(20);
		viewObjects.add(insuranceCompanyChange);
		
		insuranceIDChange = new TextField(375, 398, 175, 35, "");
		insuranceIDChange.setSize(20);
		viewObjects.add(insuranceIDChange);
		
		insurancePlanChange = new TextField(375, 448, 175, 35, "");
		insurancePlanChange.setSize(20);
		viewObjects.add(insurancePlanChange);
		
		insuranceNumberChange = new TextField(375, 498, 175, 35, "");
		insuranceNumberChange.setSize(20);
		viewObjects.add(insuranceNumberChange);
		
		Button update = new Button(815, 250, 250, 250, "UPDATE", Color.GRAY, new Action() {
			
			public void act() {
				reWrite();
				PatientInfoScreen.popper = 0;
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		update.setSize(20);
		AbstractButton.circleButton(update);
		viewObjects.add(update);
	}
	
	public void drawHead(TextArea head) {
		head.setCustomTextColor(Color.WHITE);
		head.setSize(20);
		getViewObjects().add(head);
	}
	
	public void reWrite() {
		File oldFile = new File("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/info");
		String notes = "";
		for (int i = 10; i < maxLines("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/info") + 1; i++) {
			if(i != 10) {
				notes += "\n";
			}
			notes += readLine(i, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/info");
		}
		oldFile.delete();
		
		File newFile = new File("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/info");
		String text = birthdayChange.getText() + "\n" + numberChange.getText() + "\n" + genderChange.getText() + "\n\n" + insuranceCompanyChange.getText() + "\n" + insuranceIDChange.getText() + "\n" + insurancePlanChange.getText()  + "\n" + insuranceNumberChange.getText() + "\n\n" + notes;
		try {
		    FileWriter fWriter = new FileWriter(newFile, false);
		    fWriter.write(text);
		    fWriter.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		File nameChange = new File("resources/" + Main.getDoctor() + "/patients/" + nameChange.getText());
		try {
		    FileWriter fWriter = new FileWriter(nameChange, false);
		    fWriter.write(text);
		    fWriter.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		new File("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient()).renameTo(new File("resources/" + Main.getDoctor() + "/patients/" + nameChange.getText()));
	}
}