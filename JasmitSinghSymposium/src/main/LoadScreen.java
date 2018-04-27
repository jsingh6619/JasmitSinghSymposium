package main;

import java.util.List;

import abstractClasses.AbstractScreen;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;

public class LoadScreen extends AbstractScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoadScreen(int width, int height) {
		super(width, height);
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		setBackground(getI());

	}

}
