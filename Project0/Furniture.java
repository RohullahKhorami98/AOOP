import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Furniture extends JLabel {
	public BufferedImage image;
	public Point Position;
	public Point PositionOnScreen ;
	public int xp;
	public int yp;
	

	public Furniture(String name) {
		new JLabel();
		setIcon(new ImageIcon("/Users/rohullahkhorami/Desktop/AOOP/Assginement/Project/src/" + name));
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				Position = getLocation();
				PositionOnScreen = getLocationOnScreen();
				Point temp = e.getLocationOnScreen();
			
				 xp = temp.x - PositionOnScreen.x + Position.x;
				 yp = temp.y - PositionOnScreen.y + Position.y;
				update(xp,yp);
			}
		});
	}
	
	public void update(int x, int y) {
		setLocation(x,y);
	}

}