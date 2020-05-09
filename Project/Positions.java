package Project;

import javax.swing.JOptionPane;

public class Positions {
	int x;
	int y;
	int h;
	int w;
	String x_axis;
	String y_axis;
	String height;
	String width;
	JOptionPane p;

	public Positions() {

		p = new JOptionPane();

		x_axis = p.showInputDialog("Enter Position on X-axis !");
		x = Integer.parseInt(x_axis);
		y_axis = p.showInputDialog("Enter Position on Y-axis !");
		y = Integer.parseInt(y_axis);
		height = p.showInputDialog("Enter Height of the shape !");
		h = Integer.parseInt(height);
		width = p.showInputDialog("Enter Width of the shape !");
		w = Integer.parseInt(width);

	}

}
