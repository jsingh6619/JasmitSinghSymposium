package abstractClasses;

import java.awt.Color;
import java.util.List;

import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public abstract class AbstractScreen extends FullFunctionScreen {

	private static Color a = new Color(47, 48, 66);			//background color
	private static Color b = new Color(250, 109, 109);
	private static Color c = new Color(11, 156, 250);
	private static Color d = new Color(250, 53, 203);
	private static Color e = new Color(178, 250, 241);
	private static Color f = new Color(153, 217, 234);
	private static Color g = new Color(153, 217, 234);

	public AbstractScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		
	}

	public static Color getA() {
		return a;
	}

	public static Color getB() {
		return b;
	}

	public static Color getC() {
		return c;
	}

	public static Color getD() {
		return d;
	}

	public static Color getE() {
		return e;
	}

	public static Color getF() {
		return f;
	}

	public static Color getG() {
		return g;
	}
}
