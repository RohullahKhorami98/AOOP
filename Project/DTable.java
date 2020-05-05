import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class DTable extends JLabel {
	public BufferedImage image;
	public Point Position;
	public Point PositionOnScreen;
	public DTable() {
		new JLabel();
		setIcon(new ImageIcon("/Users/rohullahkhorami/Desktop/AOOP/Assginement/Project/src/diningtable.png"));
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Position = getLocation();
				PositionOnScreen = getLocationOnScreen();
				Point temp = e.getLocationOnScreen();
				int x = temp.x - PositionOnScreen.x + Position.x;
				int y = temp.y - PositionOnScreen.y + Position.y;
				setLocation(x, y);
			}
		});
	}
}