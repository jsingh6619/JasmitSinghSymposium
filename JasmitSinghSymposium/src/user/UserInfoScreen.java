package user;

import java.awt.Color;
import java.io.*;
import java.nio.file.*;
import java.util.List;

import abstractClasses.AbstractButton;
import abstractClasses.AbstractScreen;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import main.Main;

public class UserInfoScreen extends AbstractScreen {

	public TextLabel info;
	
	public UserInfoScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		setBackground(getA());
		info = new TextColoredLabel(650, 50, 500, 225, Main.getDoctor() + "\n " + readLine(2) + "\n " + readLine(5) + "\n " + readLine(8) , getG(), Color.BLACK);
		Button patients = new Button(150, 250, 350, 350, "Patients", getB(), new Action() {
			public void act() {
				Main.main.setScreen(new PatientsScreen(getWidth(), getHeight()));
			}
		});
		AbstractButton.circleButton(patients);
		Button calendar = new Button(600, 400, 250, 250, "Calendar", getC(),  new Action() {
			public void act() {
				Main.main.setScreen(new CalendarScreen(getWidth(), getHeight()));
			}
		});
		AbstractButton.circleButton(calendar);
		Button about = new Button(950, 300, 150, 150, "About", getD(),  new Action() {
			public void act() {
				Main.main.setScreen(new AboutScreen(getWidth(), getHeight()));
			}
		});
		AbstractButton.circleButton(about);
		
		viewObjects.add(info);
		viewObjects.add(patients);
		viewObjects.add(calendar);
		viewObjects.add(about);
	}
	
	public String readLine(int x) {
		String line = "";
		try {
			FileInputStream fs= new FileInputStream("resources/" + Main.getDoctor() + "/" + Main.getDoctor() + ".txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			for(int i = 1; i < x; i++) {
				br.readLine();
			}
			line = br.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}

}
