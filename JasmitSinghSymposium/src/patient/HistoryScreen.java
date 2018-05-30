package patient;

import java.util.List;

import abstractClasses.AbstractScreen;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import main.Main;

public class HistoryScreen extends AbstractScreen {

	public static int popper = 0;

	public HistoryScreen(int width, int height) {
		super(width, height);
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		super.initAllObjects(viewObjects);
		Button notes = new Button(600, 550, 125, 125, "Notes", getG(), new Action() {
			public void act() {
				HistoryScreen.popper = 2;
				PatientInfoScreen.head = "     Notes     ";
				Main.main.setScreen(new PatientInfoScreen(getWidth(), getHeight()));
			}
		});
		notes.setSize(20);
		viewObjects.add(notes);
	}
	
	public void notary(){String note = "";
	for (int i = 10; i < maxLines("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/info") + 1; i++) {
		note += readLine(i, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/info");
		note += "\n";
	}

	//popped.addObject(new TextArea(0, 0, 1280, 720, note));
	//popped.update(); 
	//code to get notes
	}
}