package main;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.interfaces.Visible;

public class Animation extends AnimatedComponent implements Visible {

	public Animation(int x, int y, int w, int h) {
		super(x, y, w, h);
		Thread go = new Thread(this);
		go.start();
	}

}
