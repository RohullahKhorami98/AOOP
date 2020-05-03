import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Carpet extends JLabel {
	public BufferedImage image;

	public Carpet() {
		new JLabel();
		setIcon(new ImageIcon("/Users/rohullahkhorami/Desktop/AOOP/Assginement/Project/src/carpet.png"));
	}
}