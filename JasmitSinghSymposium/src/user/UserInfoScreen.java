package user;

import java.awt.Color;
import java.util.List;

import abstractClasses.*;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import main.Main;

public class UserInfoScreen extends AbstractScreen {

	public TextArea info;
	public TextLabel infoBack;
	public String file;
	
	public UserInfoScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		super.initAllObjects(viewObjects);
		file = "resources/" + Main.getDoctor() + "/" + Main.getDoctor() + ".txt";
		
		infoBack = new TextColoredLabel(750, 50, 400, 225, "", getD(), Color.BLACK);
		
		//text needs to be aligned left and font needs to be changed
		info = new TextArea(750, 50, 400, 225, Main.getDoctor() + "\n " + readLine(2,file) + "\n " + readLine(5,file) + "\n " + readLine(8,file));
		
		Button patients = new Button(225, 203, 185, 185, "Patients", getG(), new Action() {
			public void act() {
				Main.main.setScreen(new PatientsScreen(getWidth(), getHeight()));
			}
		});
		AbstractButton.circleButton(patients);
		
		Button calendar = new Button(356, 440, 240, 240, "Calendar", getE(),  new Action() {
			public void act() {
				Main.main.setScreen(new CalendarScreen(getWidth(), getHeight()));
			}
		});
		AbstractButton.circleButton(calendar);
		
		Button about = new Button(875, 380, 185, 185, "About", getF(),  new Action() {
			public void act() {
				Main.main.setScreen(new AboutScreen(getWidth(), getHeight()));
			}
		});
		AbstractButton.circleButton(about);
		
		viewObjects.add(infoBack);
		viewObjects.add(info);
		viewObjects.add(patients);
		viewObjects.add(calendar);
		viewObjects.add(about);
	}
}
