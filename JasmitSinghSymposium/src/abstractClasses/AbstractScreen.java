package abstractClasses;

import java.awt.*;
import java.io.*;
import java.util.List;

import guiTeacher.interfaces.*;
import guiTeacher.userInterfaces.*;
import main.Main;

public abstract class AbstractScreen extends FullFunctionScreen {

	private static Color a = new Color(47, 48, 66);			//background color
	private static Color b = new Color(250, 109, 109);
	private static Color c = new Color(11, 156, 250);
	private static Color d = new Color(250, 53, 203);
	private static Color e = new Color(178, 250, 241);
	private static Color f = new Color(153, 217, 234);
	private static Color g = new Color(250, 235, 229);

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
	
	public String readLine(int x, String a) {
		String line = "";
		try {
			FileInputStream fs= new FileInputStream(a);
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			for(int i = 1; i < x; i++) {
				br.readLine();
			}
			line = br.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
}
