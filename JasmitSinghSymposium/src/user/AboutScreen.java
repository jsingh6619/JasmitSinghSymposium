//have to modify readline code so it searches for a string and then stores code until next string reached
/*
 * readLine(String begin, String End, ArrayList<String> x){
 * 	//adds code between the two strings into the arraylist
 * }
 */









//have an option for the user to modify their name, d.o.b, npi #, specialty
package user;

import java.awt.Color;
import java.util.*;

import abstractClasses.*;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import main.Main;

public class AboutScreen extends AbstractScreen {

	public ArrayList<String> pop;
	public String file;

	public AboutScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		super.initAllObjects(viewObjects);
		file = "resources/" + Main.getDoctor() + "/" + Main.getDoctor() + ".txt";
		pop = new ArrayList<String>();
		
		Button back = new Button(100, 50, 1080, 200, "", getD(), new Action() {
			public void act() {
			}
		});
		back.setEnabled(false);
		
		TextArea info = new TextArea(115, 50, 400, 225, Main.getDoctor());
		TextArea info1 = new TextArea(115, 106, 400, 225, readLine(2,file));
		TextArea info2 = new TextArea(115, 150, 400, 225, readLine(5,file));
		TextArea info3 = new TextArea(115, 188, 400, 225, readLine(8,file));
		info.setSize(36);
		info1.setSize(24);
		info2.setSize(18);
		info3.setSize(18);
		
		Button education = new Button(100, 275, 450, 175, "Education", getF(),  new Action() {
			public void act() {
				pop.clear();
				//pop-up displaying arraylist
			}
		});
		education.setSize(20);
		
		Button contactInfo = new Button(100, 475, 450, 175, "Contact Info", getJ(),  new Action() {
			public void act() {
				pop.clear();
				//pop-up displaying arraylist
			}
		});
		contactInfo.setSize(20);
		
		Button workHistory = new Button(575, 275, 605, 375, "Work History", getE(),  new Action() {
			public void act() {
				pop.clear();
				//pop-up displaying arraylist
			}
		});
		workHistory.setSize(20);
		
		viewObjects.add(back);
		viewObjects.add(info);
		viewObjects.add(info1);
		viewObjects.add(info2);
		viewObjects.add(info3);
		viewObjects.add(education);
		viewObjects.add(contactInfo);
		viewObjects.add(workHistory);
	}
}
