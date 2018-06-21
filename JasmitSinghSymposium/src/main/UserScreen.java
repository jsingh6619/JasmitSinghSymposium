//no more than 5 doctors could be put on the application - set limit on later date

package main;

import java.awt.Color;
import java.io.File;
import java.util.*;


import abstractClasses.AbstractButton;
import abstractClasses.AbstractScreen;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextColoredLabel;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import user.UserInfoScreen;

public class UserScreen extends AbstractScreen {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> docName;
	private int docs;
	
	public UserScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		setBackground(getA());
		docName = new ArrayList<String>();
		docs = numberOfUsers();
		
		for(int i = 0; i < docs; i++) {
			int x = i;
			Button user = new Button(350 + 250*i, 300, 200, 200, docName.get(i), getH(), new Action() {
				public void act() {
					Main.setDoctor(docName.get(x));
					Main.main.setScreen(new UserInfoScreen(getWidth(), getHeight()));
				}
			});
			AbstractButton.circleButton(user);
			user.setSize(20);
			viewObjects.add(user);
		}
		
		TextLabel title = new TextColoredLabel(515, 150, 125, 125, "Users", getA(), Color.WHITE);
		title.setSize(40);
		viewObjects.add(title);
	}
	
	public int numberOfUsers() {
		int numberOfUsers = 0;
		File directory = new File("resources");
		File listDir[] = directory.listFiles();
		for (File x : listDir) {
			if (x.isDirectory()) {
				numberOfUsers++;
				docName.add(x.getName());
			}
		}
		return numberOfUsers;
	}
}
