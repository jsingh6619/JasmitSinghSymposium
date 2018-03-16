//have to modify readline code so it searches for a string and then stores code until next string reached
/*
 * readLine(String begin, String End, ArrayList<String> x){
 * 	//adds code between the two strings into the arraylist
 * }
 */

package user;

import java.awt.Color;
import java.util.*;

import abstractClasses.*;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import main.Main;

public class AboutScreen extends AbstractScreen {

	public TextLabel info;
	public ArrayList<String> pop;
	public String file;

	public AboutScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		setBackground(getA());
		
		file = "resources/" + Main.getDoctor() + "/" + Main.getDoctor() + ".txt";
		pop = new ArrayList<String>();
		
		info = new TextColoredLabel(100, 50, 1080, 200, Main.getDoctor() + "\n " + readLine(2,file) + "\n " + readLine(5,file) + "\n " + readLine(8,file) , getG(), Color.BLACK);
		
		Button education = new Button(100, 275, 450, 175, "Education", getC(),  new Action() {
			public void act() {
				pop.clear();
				//pop-up displaying arraylist
			}
		});
		
		Button contactInfo = new Button(100, 475, 450, 175, "Contact Info", getD(),  new Action() {
			public void act() {
				pop.clear();
				//pop-up displaying arraylist
			}
		});
		
		Button workHistory = new Button(575, 275, 605, 375, "Work History", getE(),  new Action() {
			public void act() {
				pop.clear();
				//pop-up displaying arraylist
			}
		});
		
		viewObjects.add(info);
		viewObjects.add(education);
		viewObjects.add(contactInfo);
		viewObjects.add(workHistory);
	}
}