package Project;

import javax.swing.JOptionPane;

public class Positions {

	int h;
	int w;
	int s;

	JOptionPane p;

	@SuppressWarnings("static-access")
	public Positions() {
		p = new JOptionPane();

		String shapeColor = p.showInputDialog(
				"Enter Color of the shape! Red = 0  Black = 1  Blue = 2   Green = 3   Gray = 4   Cyan = 5");
		String height = p.showInputDialog("Enter Height of the shape !");
		String width = p.showInputDialog("Enter Width of the shape !");
		if (shapeColor != null) {
			s = Integer.parseInt(shapeColor);
			if (height != null && width != null) {
				h = Integer.parseInt(height);
				w = Integer.parseInt(width);
			} else {
				p.remove(h);
				p.remove(w);
			}

		} else {
			p.remove(s);

		}

	}

}
