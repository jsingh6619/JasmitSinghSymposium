package main;

import java.util.List;

import abstractClasses.AbstractScreen;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;

public class LoadScreen extends AbstractScreen {

	public LoadScreen(int width, int height) {
		super(width, height);
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		Button user = new Button(100, 100, 100, 100, "HI", getB(), new Action() {
			public void act() {
				Main.main.setScreen(Main.userInfoScreen);
			}
		});
		viewObjects.add(user);
	}

}
