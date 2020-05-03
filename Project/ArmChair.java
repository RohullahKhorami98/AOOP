import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ArmChair extends JLabel {
	public BufferedImage image;

	public ArmChair() {
		new JLabel();
		setIcon(new ImageIcon("/Users/rohullahkhorami/Desktop/AOOP/Assginement/Project/src/armchairleader.png"));
	}
}