package Project;
import javax.swing.JOptionPane;

/**
 * 
 * @author Rohullah Khorami & Willaim Wahlberg 
 * <h> Position
 * <p> position class takes input from user using input dialogs.
 * if user clicks cancel or does not give a input, the function 
 * will abort the process and set checkRead to false.
 */
public class Positions {
	boolean checkRead;
	int h = 0;
	int w = 0;
	int sc = 0;
	int shape = 0;

	String shapeColor;
	String shapeChanger;
	String height;
	String width;

	JOptionPane p;

	@SuppressWarnings("static-access")
	public Positions() {
		p = new JOptionPane();
		checkRead = true;

		shapeColor = p.showInputDialog(
				"Enter Color of the shape! Red = 1  Black = 2  Blue = 3   Green = 4   Gray = 5   Cyan = 6  Pink > 6");
		if (shapeColor == null) {
			p.showMessageDialog(null, "Cancel!", "Error", p.ERROR_MESSAGE);
			checkRead = false;
		} else if (shapeColor.equals("")) {
			p.showMessageDialog(null, "input is missing!", "Error", p.ERROR_MESSAGE);
			checkRead = false;
		} else if (Integer.parseInt(shapeColor) < 1 || Integer.parseInt(shapeColor) > 6) {
			p.showMessageDialog(null, "input is out of bounds!", "Error", p.ERROR_MESSAGE);
			checkRead = false;
		} else {
			shapeChanger = p.showInputDialog("Choose shapes! Circle = 1 Round Square/Rec  = 2  Square/Rec > 2 ");
			if (shapeChanger == null) {
				p.showMessageDialog(null, "Cancel!", "Error", p.ERROR_MESSAGE);
				checkRead = false;
			} else if (shapeChanger.equals("")) {
				p.showMessageDialog(null, "input is missing!", "Error", p.ERROR_MESSAGE);
				checkRead = false;
			} else if (Integer.parseInt(shapeChanger) < 1) {
				p.showMessageDialog(null, "input is out of bounds!", "Error", p.ERROR_MESSAGE);
				checkRead = false;
			} else {
				height = p.showInputDialog("Enter Height of the shape !");
				if (height == null) {
					p.showMessageDialog(null, "Cancel!", "Error", p.ERROR_MESSAGE);
					checkRead = false;
				} else if (height.equals("")) {
					p.showMessageDialog(null, "input is missing!", "Error", p.ERROR_MESSAGE);
					checkRead = false;
				} else if (Integer.parseInt(height) < 1 || Integer.parseInt(height) > 250) {
					p.showMessageDialog(null, "input is out of bounds!", "Error", p.ERROR_MESSAGE);
					checkRead = false;
				} else {
					width = p.showInputDialog("Enter Width of the shape !");
					if (width == null) {
						p.showMessageDialog(null, "Cancel!", "Error", p.ERROR_MESSAGE);
						checkRead = false;
					} else if (width.equals("")) {
						p.showMessageDialog(null, "input is missing!", "Error", p.ERROR_MESSAGE);
						checkRead = false;
					} else if (Integer.parseInt(width) < 1 || Integer.parseInt(width) > 250) {
						p.showMessageDialog(null, "input is out of bounds!", "Error", p.ERROR_MESSAGE);
						checkRead = false;
					} else {
						h = Integer.parseInt(height);
						w = Integer.parseInt(width);
						sc = Integer.parseInt(shapeColor);
						shape = Integer.parseInt(shapeChanger);
					}
				}
			}
		}
	}

	public boolean check() {
		return checkRead;
	}
}
