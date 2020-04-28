import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Color_changer extends JLabel {
	static JFrame frame;
	static Color color = Color.red;
	int x = 50;
	int y = 100; 
	int width = 200;
	int height = 200;

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(color);
		g.drawOval(x, y, width, height);
		g.fillOval(x, y, width, height);
	}

	public static void main(String[] args) {
		frame = new JFrame("Color Changer");
		frame.setSize(450, 450);
		Color_changer m = new Color_changer();
		frame.add(m);

		JButton red = new JButton("Red");
		red.setForeground(Color.red);
		frame.add(m.add(red), BorderLayout.EAST);
		JButton green = new JButton("Green");
		green.setForeground(Color.green);
		frame.add(m.add(green), BorderLayout.NORTH);
		JButton blue = new JButton("Blue");
		blue.setForeground(Color.blue);
		frame.add(m.add(blue), BorderLayout.WEST);

		red.addActionListener(event -> {
			color = Color.red;
			m.repaint();
		});
		green.addActionListener(event -> {
			color = Color.green;
			m.repaint();
		});
		blue.addActionListener(event -> {

			color = Color.blue;
			m.repaint();
		});

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}