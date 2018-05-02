//have to modify readline code so it searches for a string and then stores code until next string reached
/*
 * readLine(String begin, String End, ArrayList<String> x){
 * 	//adds code between the two strings into the arraylist
 * }
 */









//have an option for the user to modify their name, d.o.b, npi #, specialty
package user;

import java.awt.Color;
import java.util.*;

import abstractClasses.*;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import main.Main;

public class AboutScreen extends AbstractScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String file;
	public static int popper = 0;
	public ScrollablePane scroll;

	public AboutScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		super.initAllObjects(viewObjects);
		file = "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + ".txt";
		
		Button back = new Button(100, 50, 1080, 200, "", getD(), new Action() {
			public void act() {
			}
		});
		back.setEnabled(false);
		
		TextArea info = new TextArea(115, 50, 400, 225, Main.getPatient());
		TextArea info1 = new TextArea(115, 106, 400, 225, readLine(2,file));
		TextArea info2 = new TextArea(115, 150, 400, 225, readLine(5,file));
		TextArea info3 = new TextArea(115, 188, 400, 225, readLine(8,file));
		info.setSize(36);
		info1.setSize(24);
		info2.setSize(18);
		info3.setSize(18);
		
				
		Button education = new Button(100, 275, 450, 175, "Education", getF(),  new Action() {
			public void act() {
				AboutScreen.popper = 1;
				Main.main.setScreen(new AboutScreen(getWidth(), getHeight()));
			}
		});
		education.setSize(20);
		
		Button contactInfo = new Button(100, 475, 450, 175, "Contact Info", getJ(),  new Action() {
			public void act() {
				AboutScreen.popper = 2;
				Main.main.setScreen(new AboutScreen(getWidth(), getHeight()));
			}
		});
		contactInfo.setSize(20);
		
		Button workHistory = new Button(575, 275, 605, 375, "Work History", getE(),  new Action() {
			public void act() {
				AboutScreen.popper = 3;
				Main.main.setScreen(new AboutScreen(getWidth(), getHeight()));
			}
		});
		workHistory.setSize(20);
		
		viewObjects.add(back);
		viewObjects.add(info);
		viewObjects.add(info1);
		viewObjects.add(info2);
		viewObjects.add(info3);
		viewObjects.add(education);
		viewObjects.add(contactInfo);
		viewObjects.add(workHistory);
		
		if(popper == 1) {
			createPopup("EDUCATION");
		}
		
		if(popper == 2) {
			createPopup(" CONTACT ");
		}
		
		if(popper == 3) {
			createPopup("WORK HIST");
		}
	}

	public void populateScroll() {
		if(popper == 1) {
			scroll.removeAll();
			TextArea bachelors = new TextArea(10, 10, 260, 150, readLine(11,file) + "\n" + readLine(12,file));
			TextArea doctors = new TextArea(10, 100, 260, 150, readLine(13,file) + "\n" + readLine(14,file));
			bachelors.setSize(20);
			doctors.setSize(20);
			scroll.addObject(bachelors);
			scroll.addObject(doctors);
		}
		
		if(popper == 2) {
			scroll.removeAll();
			TextArea bachelors = new TextArea(10, 10, 260, 150, readLine(17,file) + "\n" + readLine(18,file));
			TextArea doctors = new TextArea(10, 100, 260, 150, readLine(19,file) + "\n" + readLine(20,file));
			bachelors.setSize(20);
			doctors.setSize(20);
			scroll.addObject(bachelors);
			scroll.addObject(doctors);
		}
		
		if(popper == 3) {
			scroll.removeAll();
			TextArea bachelors = new TextArea(10, 10, 260, 150, "add to text first");
			TextArea doctors = new TextArea(10, 100, 260, 150, "add to text first");
			bachelors.setSize(20);
			doctors.setSize(20);
			scroll.addObject(bachelors);
			scroll.addObject(doctors);
		}
	}
	
	public void createPopup(String head) {
		Button leftExit = new Button(0, 0, 480, 720, "", getA(), new Action() {
			
			public void act() {
				AboutScreen.popper = 0;
				Main.main.setScreen(new AboutScreen(getWidth(), getHeight()));
			}
		});
		leftExit.enable = false;
		
		Button topExit = new Button(0, 0, 1280, 50, "", getA(), new Action() {
			
			public void act() {
				AboutScreen.popper = 0;
				Main.main.setScreen(new AboutScreen(getWidth(), getHeight()));
			}
		});
		topExit.enable = false;
		
		Button bottomExit = new Button(0, 650, 1280, 70, "", getA(), new Action() {
			
			public void act() {
				AboutScreen.popper = 0;
				Main.main.setScreen(new AboutScreen(getWidth(), getHeight()));
			}
		});
		bottomExit.enable = false;
		
		Button rightExit = new Button(800, 0, 480, 720, "", getA(), new Action() {
			
			public void act() {
				AboutScreen.popper = 0;
				Main.main.setScreen(new AboutScreen(getWidth(), getHeight()));
			}
		});
		rightExit.enable = false;
		
		getViewObjects().removeAll(getViewObjects());

		Button popup = new Button(480, 50, 320, 600, "", getC(), new Action() {
			public void act() {
			}
		});
		popup.setEnabled(false);
					
		TextLabel title = new TextLabel(540, 75, 200, 125, head);
		title.setSize(35);
		
		scroll = new ScrollablePane(this, 500, 135, 280, 500);
		scroll.setBackground(new Color(108, 195, 252));
		populateScroll();
		
		Button exit = new Button(750, 50, 50, 50, "x", scroll.getBackground(), new Action() {
			
			public void act() {
				AboutScreen.popper = 0;
				Main.main.setScreen(new AboutScreen(getWidth(), getHeight()));
			}
		});
		exit.setSize(20);
		
		getViewObjects().add(leftExit);
		getViewObjects().add(topExit);
		getViewObjects().add(bottomExit);
		getViewObjects().add(rightExit);
		getViewObjects().add(popup);
		getViewObjects().add(title);
		getViewObjects().add(scroll);
		getViewObjects().add(exit);
	}
}
