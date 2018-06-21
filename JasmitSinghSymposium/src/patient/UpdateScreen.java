package patient;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import abstractClasses.AbstractScreen;
import guiTeacher.components.*;
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
	private TextField famHistChange;
	private TextField allergyChange;
	private String all = "";
	public static ScrollablePane famHist;
	public static ScrollablePane allergies;
	public static TextField allegies;
	public static TextField familyHistory;
	
	
	public UpdateScreen(int width, int height) {
		super(width, height);
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		super.initAllObjects(viewObjects);
		TextArea header = new TextArea(150, 35, 1230, 670, "What would you like to edit for " + Main.getPatient() + "?");
		header.setSize(45);
		header.setCustomTextColor(Color.WHITE);
		viewObjects.add(header);
		
		TextArea info = new TextArea(150, 100, 1230, 670, "Remember to fill out all fields, or they will be left blank.");
		info.setSize(25);
		info.setCustomTextColor(Color.WHITE);
		viewObjects.add(info);
		
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
		
		Button update = new Button(150, 550, 400, 100, "UPDATE", Color.GRAY, new Action() {
			
			public void act() {
				reWrite(0);
				PatientInfoScreen.popper = 0;
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		update.setSize(20);
		viewObjects.add(update);
		
		famHist = new ScrollablePane(this, 600, 150, 530, 150);
		famHist.setBackground(getB());
		populateScroll(1);
		
		allergies = new ScrollablePane(this, 600, 400, 530, 150);
		allergies.setBackground(getE());
		populateScroll(2);
		
		viewObjects.add(famHist);
		viewObjects.add(allergies);
		
		famHistChange = new TextField(605, 330, 255, 35, "k");
		famHistChange.setSize(20);
		viewObjects.add(famHistChange);
		
		allergyChange = new TextField(605, 580, 255, 35, "");
		allergyChange.setSize(20);
		viewObjects.add(allergyChange);
		
		Button addFam = new Button(865, 320, 260, 20, "Add", Color.GRAY, new Action() {
			public void act() {
				reWrite(1);
				Main.main.setScreen(new UpdateScreen(getWidth(), getHeight()));
			}
		});
		
		viewObjects.add(addFam);
		
		Button addAllergy = new Button(865, 320, 260, 50, "Add", Color.GRAY, new Action() {
			public void act() {
				reWrite(2);
				Main.main.setScreen(new UpdateScreen(getWidth(), getHeight()));
			}
		});
		
		viewObjects.add(addAllergy);
	}
	
	public void populateScroll(int x) {
		if (x == 1) {
			drawTextArea(new TextArea(10, -10, 340, 50, "FAMILY HISTORY"), 35, famHist);
			for(int i = 1; i < maxLines("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/health") + 1; i++) {
				drawTextArea(new TextArea(10, 25*(i) + 5, 340, 45, readLine(i, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/health")), 24, famHist);
			}
			if(readLine(1, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/health") == null){
				drawTextArea(new TextArea(10, 25 + 5, 340, 45, "NONE"), 24, famHist);
			}
			famHist.update();
		}
		else {
			drawTextArea(new TextArea(10, -10, 340, 50, "ALLERGIES"), 35, allergies);
			for(int i = 1; i < maxLines("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/allergies") + 1; i++) {
				drawTextArea(new TextArea(10, 25*(i) + 5, 340, 45, readLine(i, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/allergies")), 24, allergies);
			}
			if(readLine(1, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/allergies") == null){
				drawTextArea(new TextArea(10, 25 + 5, 340, 45, "NONE"), 24, allergies);
			}
			allergies.update();
		}
	}

	public void drawHead(TextArea head) {
		head.setCustomTextColor(Color.WHITE);
		head.setSize(20);
		getViewObjects().add(head);
	}
	
	public void reWrite(int x) {
		if(x == 0) {
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
		}
		if(x == 1) {
			File oldFile = new File("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/health");
			for (int i = 1; i < maxLines("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/health") + 1; i++) {
				all += readLine(i, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/health") + "\n";
			}
			all += famHistChange.getText();
			System.out.println(all);
			oldFile.delete();
			File newFile = new File("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/health");
			try {
			    FileWriter fWriter = new FileWriter(newFile, false);
			    fWriter.write(all);
			    fWriter.close();
			} catch (IOException e) {
			    e.printStackTrace();
			}
		}
		if(x == 2) {
			File oldFile = new File("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/allergies");
			for (int i = 1; i < maxLines("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/allergies") + 1; i++) {
				all += readLine(i, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/allergies") + "\n";
			}
			all += famHistChange.getText();
			System.out.println(all);
			oldFile.delete();
			File newFile = new File("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/allergies");
			try {
			    FileWriter fWriter = new FileWriter(newFile, false);
			    fWriter.write(all);
			    fWriter.close();
			} catch (IOException e) {
			    e.printStackTrace();
			}
		}
	}
}