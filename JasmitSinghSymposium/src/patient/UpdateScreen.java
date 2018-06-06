package patient;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
		TextArea header = new TextArea(25, 25, 1230, 670, "What would you like to edit for " + Main.getPatient() + "?");
		header.setSize(45);
		viewObjects.add(header);
		
		drawHead(new TextArea(150, 125, 225, 100, "Name: "));
		drawHead(new TextArea(150, 175, 225, 100, "D.O.B: "));
		drawHead(new TextArea(150, 225, 225, 100, "Gender: "));
		drawHead(new TextArea(150, 275, 225, 100, "Number: "));
		drawHead(new TextArea(150, 325, 225, 100, "Insurance Company: "));
		drawHead(new TextArea(150, 375, 225, 100, "Insurance ID: "));
		drawHead(new TextArea(150, 425, 225, 100, "Insurance Plan: "));
		drawHead(new TextArea(150, 475, 225, 100, "Insurance Number: "));
		
		nameChange = new TextField(375, 123, 175, 35, "print");
		nameChange.setSize(20);
		viewObjects.add(nameChange);
		
		birthdayChange = new TextField(375, 173, 175, 35, "print");
		birthdayChange.setSize(20);
		viewObjects.add(birthdayChange);
		
		genderChange = new TextField(375, 223, 175, 35, "print");
		genderChange.setSize(20);
		viewObjects.add(genderChange);
		
		numberChange = new TextField(375, 273, 175, 35, "print");
		numberChange.setSize(20);
		viewObjects.add(numberChange);
		
		insuranceCompanyChange = new TextField(375, 323, 175, 35, "print");
		insuranceCompanyChange.setSize(20);
		viewObjects.add(insuranceCompanyChange);
		
		insuranceIDChange = new TextField(375, 373, 175, 35, "print");
		insuranceIDChange.setSize(20);
		viewObjects.add(insuranceIDChange);
		
		insurancePlanChange = new TextField(375, 423, 175, 35, "print");
		insurancePlanChange.setSize(20);
		viewObjects.add(insurancePlanChange);
		
		insuranceNumberChange = new TextField(375, 473, 175, 35, "print");
		insuranceNumberChange.setSize(20);
		viewObjects.add(insuranceNumberChange);
		
		Button update = new Button(150, 600, 100, 100, "TEST", new Action() {
			
			public void act() {
				reWrite();
				PatientInfoScreen.popper = 0;
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		viewObjects.add(update);
	}
	
	public void drawHead(TextArea head) {
		head.setCustomTextColor(Color.WHITE);
		head.setSize(20);
		getViewObjects().add(head);
	}
	
	public void reWrite() {
		File override = new File("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/info");
		override.delete();
		File newFile = new File("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/info");
		String source = nameChange.getText() + "\n" + birthdayChange.getText() + "\n" + genderChange.getText() + "\n" + numberChange.getText() + "\n" + insuranceCompanyChange.getText() + "\n" + insuranceIDChange.getText() + "\n" + insurancePlanChange.getText()  + "\n" + insuranceNumberChange.getText();
		try {
		    FileWriter f2 = new FileWriter(newFile, false);
		    f2.write(source);
		    f2.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
}