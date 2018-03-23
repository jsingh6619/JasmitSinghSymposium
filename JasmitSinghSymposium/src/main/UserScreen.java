//no more than 5 doctors could be put on the application - set limit on later date

package main;

import java.io.File;
import java.util.*;


import abstractClasses.AbstractButton;
import abstractClasses.AbstractScreen;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;
import user.UserInfoScreen;

public class UserScreen extends AbstractScreen {
	
	private ArrayList<String> docName;
	private int docs;
	private String doctor;
	
	public UserScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		super.initAllObjects(viewObjects);
		
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
			viewObjects.add(user);
		}
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