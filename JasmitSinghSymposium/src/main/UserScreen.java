package main;

import java.io.File;
import java.util.*;


import abstractClasses.AbstractButton;
import abstractClasses.AbstractScreen;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;

public class UserScreen extends AbstractScreen {
	
	private ArrayList<String> docName;
	private int docs;
	
	public UserScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		docName = new ArrayList<String>();
		docs = numberOfUsers();
		for(int i = 0; i < docs; i++) {
			Button user = new Button(100, 100, 100, 100, docName.get(i), getB(), new Action() {
				public void act() {
					Main.main.setDoctor("Doctor");
					Main.main.setScreen(Main.userInfoScreen);
				}
			});
			AbstractButton.circleButton(user);
			viewObjects.add(user);
		}
		System.out.println(docName.size());
	}
		//need to keep track of what doctor folder and what patient text file the user has selected
	
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