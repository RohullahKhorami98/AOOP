import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Table extends JLabel {
	public BufferedImage image;

	public Table() {
		new JLabel();
		setIcon(new ImageIcon("/Users/rohullahkhorami/Desktop/AOOP/Assginement/Project/src/table2.png"));
	}
}