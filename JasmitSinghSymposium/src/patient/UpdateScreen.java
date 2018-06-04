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
		drawField(nameChange, 123);
		drawField(birthdayChange, 173);
		drawField(genderChange, 223);
		drawField(numberChange, 273);
		System.out.print(numberChange.getText());
		drawField(insuranceCompanyChange, 323);
		drawField(insuranceIDChange, 373);
		drawField(insurancePlanChange, 423);
		drawField(insuranceNumberChange, 473);
		Button update = new Button(150, 600, 100, 100, "TEST", new Action() {
			
			public void act() {
				System.out.print(numberChange.getText());
			}
		});
		viewObjects.add(update);
	}
	
	public void drawField(TextField field, int y) {
		field = new TextField(375, y, 175, 35, "print");
		field.setSize(20);
		getViewObjects().add(field);
	}
	
	public void drawHead(TextArea head) {
		head.setCustomTextColor(Color.WHITE);
		head.setSize(20);
		getViewObjects().add(head);
	}
	
//	public void reWrite() {
//		File fold=new File("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/info");
//		fold.delete();
//		File fnew=new File("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/info");
//		String source = nameChange.getText() + "\n" + birthdayChange.getText() + "\n" + genderChange.getText() + "\n" + numberChange.getText() + "\n" + insuranceCompanyChange.getText() + "\n" + insuranceIDChange.getText() + "\n" + insurancePlanChange.getText()  + "\n" + insuranceNumberChange.getText();
//		System.out.println(source);
//		try {
//		    FileWriter f2 = new FileWriter(fnew, false);
//		    f2.write(source);
//		    f2.close();
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}  
//	}
}