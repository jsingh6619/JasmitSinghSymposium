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
		file = "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + ".txt";
		
		Button back = new Button(100, 50, 540, 200, "", getD(), new Action() {
			public void act() {
			}
		});
		back.setEnabled(false);
		
		TextArea info = new TextArea(115, 50, 400, 225, Main.getPatient());
		//TextArea info1 = new TextArea(115, 106, 400, 225, readLine(2,file));
		//TextArea info2 = new TextArea(115, 150, 400, 225, readLine(5,file));
		//TextArea info3 = new TextArea(115, 188, 400, 225, readLine(8,file));
		
		viewObjects.add(info);
		//viewObjects.add(info1);
		//viewObjects.add(info2);
		//viewObjects.add(info3);
	}
}
