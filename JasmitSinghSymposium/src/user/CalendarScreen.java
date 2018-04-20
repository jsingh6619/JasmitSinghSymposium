package user;

import java.awt.Color;
import java.util.List;

import abstractClasses.AbstractScreen;
import guiTeacher.components.*;
import guiTeacher.interfaces.*;

public class CalendarScreen extends AbstractScreen {

	private TextLabel title;
	
	public CalendarScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		super.initAllObjects(viewObjects);
		title = new TextColoredLabel(x, y, w, h, "Calendar", Color.BLACK, Color.WHITE)
	}

}
