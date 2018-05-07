package patient;

import java.util.List;

import abstractClasses.AbstractScreen;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import main.Main;

public class PatientInfoScreen extends AbstractScreen {

	public String file;
	
	public PatientInfoScreen(int width, int height) {
		super(width, height);
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		super.initAllObjects(viewObjects);
		file = "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient();
		
		Button back = new Button(100, 50, 540, 200, "", getD(), new Action() {
			public void act() {
			}
		});
		back.setEnabled(false);
		
		TextArea name = new TextArea(115, 50, 400, 225, Main.getPatient());
		name.setSize(36);
		TextArea dob = new TextArea(115, 106, 400, 225, readLine(1,file));
		dob.setSize(24);
		TextArea number = new TextArea(115, 150, 400, 225, readLine(2,file));
		//TextArea info3 = new TextArea(115, 188, 400, 225, readLine(8,file));
		
		viewObjects.add(back);
		viewObjects.add(name);
		viewObjects.add(dob);
		viewObjects.add(number);
		//viewObjects.add(info3);
	}
}
