package user;

import java.awt.Color;
import java.util.List;

import abstractClasses.AbstractScreen;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import main.Main;

public class UserInfoScreen extends AbstractScreen {

	public UserInfoScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		setBackground(getA());
		System.out.print(Main.getDoctor());
		TextLabel info = new TextColoredLabel(100, 100, 100, 100, Main.getDoctor() + "\n" + , getG(), Color.BLACK);
		info.setBackgroundColor(getB());
		viewObjects.add(info);
		System.out.println("added");
	}

}
