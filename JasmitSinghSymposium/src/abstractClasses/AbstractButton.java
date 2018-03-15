package abstractClasses;

import java.awt.Color;

import guiTeacher.components.*;

public abstract class AbstractButton extends Button {
	
	private static Color a = new Color(153, 217, 234);
	private static Color b = new Color(241, 75, 84);
	private static Color c = new Color(111, 119, 217);
	
	public AbstractButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
	}
	
	public AbstractButton(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
	}
	
	public static void circleButton(Button b){
		b.setDimensions(b.getWidth(), b.getWidth());
		b.setCurve(b.getWidth(), b.getWidth());
	}
}