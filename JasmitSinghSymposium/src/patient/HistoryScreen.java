package patient;

import java.awt.Color;
import java.util.List;

import abstractClasses.AbstractScreen;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ScrollablePane;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import main.Main;
import user.PatientsScreen;

public class HistoryScreen extends AbstractScreen {

	public static ScrollablePane height;
	public static ScrollablePane weight;
	public static ScrollablePane notes;
	
	private static final long serialVersionUID = 1L;
	public static int popper = 0;

	public HistoryScreen(int width, int height) {
		super(width, height);
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		super.initAllObjects(viewObjects);
		
		notes = new ScrollablePane(this, 50, 50, 1180, 620);
		notes.setBackground(getB());
		
//		Button add = new Button(1100, 330, 100, 100, "Add", Color.WHITE, new Action() {
//			
//			public void act() {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
//		height = new ScrollablePane(this, 50, 50, 650, 620);
//		height.setBackground(getB());
//		
//		weight = new ScrollablePane(this, 50, 50, 650, 620);
//		weight.setBackground(getB());
		
		populateScroll(1);
//		populateScroll(2);
//		populateScroll(3);

		viewObjects.add(notes); 
//		viewObjects.add(height);
//		viewObjects.add(weight);
//		viewObjects.add(add); 
	}
	
	public void populateScroll(int i) {
		if(i == 1) {
			for(int j = 10; j < maxLines("resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/info") + 1; j++) {
				int k = j-9;
				drawTextArea(new TextArea(35, 25*(k-1), 1110, 150, readLine(j, "resources/" + Main.getDoctor() + "/patients/" + Main.getPatient() + "/info")), 24, notes);
			}
			notes.update();
		}
//		if(i == 2) {
//			height
//		}
//		if(i == 3) {
//			weight
//		}
	}
}