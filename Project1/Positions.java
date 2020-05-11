package Project;

import javax.swing.JOptionPane;

public class Positions {

	int h = 0;
	int w = 0;
	int sc = 0;
	int shape = 0;
	
	String shapeColor;
	String shapeChanger ;
	String height ;
	String width ;
	

	JOptionPane p;

	@SuppressWarnings("static-access")
	public Positions() {
		p = new JOptionPane();

		 shapeColor = p.showInputDialog(
				"Enter Color of the shape! Red = 1  Black = 2  Blue = 3   Green = 4   Gray = 5   Cyan = 6");
		if(!shapeColor.equals("")) {
			sc = Integer.parseInt(shapeColor);
			 shapeChanger = p.showInputDialog("Choose shapes! Circle = 1  Round Square/Rec = 2  Square/Rec > 2 ");
			 if(!shapeChanger.equals("")) {
				 shape = Integer.parseInt(shapeChanger);
				 height = p.showInputDialog("Enter Height of the shape !");
				 width = p.showInputDialog("Enter Width of the shape !");
				 if(!height.equals("") || !width.equals("")) {
						h = Integer.parseInt(height);
						w = Integer.parseInt(width);
				 }
				 else {
					 p.showMessageDialog(null, "Width or Height is missing!" , "Error" , p.ERROR_MESSAGE);
					 p.remove(h);
					 p.remove(w);
					 
				 }
			 }
			 else {
				 p.showMessageDialog(null, "Please select a Shape!" , "Error" , p.ERROR_MESSAGE);
				 p.remove(shape);
			 }
		}
		else {
			p.showMessageDialog(null, "Please Choose a Color!" , "Error" , p.ERROR_MESSAGE);
			p.remove(sc);
		}
	}

}
