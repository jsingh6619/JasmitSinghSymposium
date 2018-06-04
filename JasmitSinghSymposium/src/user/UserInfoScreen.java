package user;

import java.util.List;

import abstractClasses.*;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import main.Main;

public class UserInfoScreen extends AbstractScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String file;
	
	public UserInfoScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		super.initAllObjects(viewObjects);
		file = "resources/" + Main.getDoctor() + "/" + Main.getDoctor() + ".txt";
		Button back = new Button(750, 50, 400, 188, "", getD(), new Action() {
			public void act() {
			}
		});
		back.setEnabled(false);
		viewObjects.add(back);
		
		drawTextArea(new TextArea(765, 50, 400, 225, Main.getDoctor()), 36);
		drawTextArea(new TextArea(765, 106, 400, 225, readLine(2,file)), 24);
		drawTextArea(new TextArea(765, 150, 400, 225, readLine(5,file)), 18);
		drawTextArea(new TextArea(765, 188, 400, 225, readLine(8,file)), 18);

		Button patients = new Button(225, 203, 185, 185, "Patients", getG(), new Action() {
			public void act() {
				Main.main.setScreen(new PatientsScreen(getWidth(), getHeight()));
			}
		});
		patients.setSize(20);
		AbstractButton.circleButton(patients);
		
		Button calendar = new Button(356, 440, 240, 240, "Calendar", getE(),  new Action() {
			public void act() {
				Main.main.setScreen(new CalendarScreen(getWidth(), getHeight()));
			}
		});
		calendar.setSize(20);
		AbstractButton.circleButton(calendar);
		
		Button about = new Button(875, 380, 185, 185, "About", getF(),  new Action() {
			public void act() {
				Main.main.setScreen(new AboutScreen(getWidth(), getHeight()));
			}
		});
		about.setSize(20);
		AbstractButton.circleButton(about);
		
		viewObjects.add(patients);
		viewObjects.add(calendar);
		viewObjects.add(about);
	}
}
