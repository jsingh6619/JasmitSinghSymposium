package patient;

import java.util.List;

import abstractClasses.AbstractScreen;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import main.Main;

public class UpdateScreen extends AbstractScreen {

	public UpdateScreen(int width, int height) {
		super(width, height);
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		super.initAllObjects(viewObjects);
		TextArea header = new TextArea(25, 25, 1230, 670, "What would you like to edit for " + Main.getPatient() + "?");
		header.setSize(45);
		viewObjects.add(header);
	}
}