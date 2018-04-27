package user;

import java.awt.Color;
import java.util.List;

import abstractClasses.AbstractScreen;
import guiTeacher.components.*;
import guiTeacher.interfaces.*;

public class CalendarScreen extends AbstractScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TextLabel title;
	
	public CalendarScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		super.initAllObjects(viewObjects);
		title = new TextColoredLabel(1, 1, 1, 1, "Calendar", Color.BLACK, Color.WHITE);
	}

}
