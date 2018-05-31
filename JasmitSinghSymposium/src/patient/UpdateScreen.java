package patient;

import java.awt.Color;
import java.util.List;

import abstractClasses.AbstractScreen;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import main.Main;

public class UpdateScreen extends AbstractScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static TextField nameChange;
	public static TextField birthdayChange;
	public static TextField genderChange;
	public static TextField numberChange;
	public static TextField insuranceCompanyChange;
	public static TextField insuranceIDChange;
	public static TextField insuranceNumberChange;
	public static TextField insurancePlanChange;
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
		
		drawHead(new TextArea(990, 125, 125, 100, "Name: "));
		drawHead(new TextArea(990, 175, 125, 100, "D.O.B: "));
		drawField(nameChange, 123);
		drawField(birthdayChange, 173);
	}
	
	public void drawField(TextField field, int y) {
		field = new TextField(1050, y, 175, 35, "");
		field.setSize(20);
		field.setDrawBorder(false);
		getViewObjects().add(field);
	}
	
	public void drawHead(TextArea head) {
		head.setCustomTextColor(Color.WHITE);
		head.setSize(20);
		getViewObjects().add(head);
	}
}