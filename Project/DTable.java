import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class DTable extends JLabel {
	public BufferedImage image;

	public DTable() {
		new JLabel();
		setIcon(new ImageIcon("/Users/rohullahkhorami/Desktop/AOOP/Assginement/Project/src/diningtable.png"));
	}
}