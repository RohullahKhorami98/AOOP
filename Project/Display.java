import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class Display extends Button {

	JFrame frame;
	static Room canvas;
	JTextArea text;
	JPanel buttonpanel;
	String info[] = { "Chiar", "Table", "Sofa", "ArmChair", "WarDrope", "light", "TV" };
	static String image_list[] = {};
	static int currentImage;

	JMenuBar menu;
	JMenu File;
	JMenu Edit;
	JMenuItem Save;
	JMenuItem close;
	JMenuItem Minimize;
	JMenuItem Maximize;
	JMenuItem open;
	

	public Display() {

		frame = new JFrame();
		frame.setSize(1200, 900);
		frame.setLayout(new BorderLayout());
		buttonpanel = new JPanel();
		buttonpanel.setSize(200, 800);
		buttonpanel.setLayout(new BoxLayout(buttonpanel, BoxLayout.Y_AXIS));
		buttonpanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		buttonpanel.setBackground(Color.decode("#6E6E6E"));
		frame.add(buttonpanel, BorderLayout.LINE_END);

		text = new JTextArea("Good job");
		text.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		text.setBackground(Color.decode("#D8D8D8"));
		text.setForeground(Color.red);
		text.setPreferredSize(new Dimension(100, 100));
		text.setEditable(false);
		frame.add(text);
		frame.add(text, BorderLayout.PAGE_END);

		menu = new JMenuBar();
		 
		frame.setJMenuBar(menu);
		
		File = new JMenu("File");
		menu.add(File);
		
		Save = new JMenuItem("Save");
		File.add(Save);
		close = new JMenuItem("Close");
		File.add(close);
		open = new JMenuItem("Open");
		
		File.add(open);
		
		Edit = new JMenu("Edit");
		menu.add(Edit);
		Minimize = new JMenuItem("Minimize");
		Edit.add(Minimize);
		Maximize = new JMenuItem("Maximize");
		Edit.add(Maximize);

		
		

		canvas = new Room();
		canvas.setBackground(Color.decode("#A4A4A4"));
		frame.add(canvas, BorderLayout.CENTER);

		initButtons();
		for (int i = 0; i < nrOfButtons; i++) {
			buttonpanel.add(buttons[i]);
			buttonpanel.add(Box.createVerticalGlue());

		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static BufferedImage Pic() throws IOException {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(
					"/Users/rohullahkhorami/Desktop/AOOP/Assginement/Project/src/" + image_list[currentImage]));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;
	}

	public static void DrawImage() {
		BufferedImage pic = null;
		try {
			pic = Pic();
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		canvas.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();

		switch (event) {
		case "Chair":

			setButtonColor(0);
			text.setText(info[0]);

			break;
		case "Table":
			setButtonColor(1);
			text.setText(info[1]);
			break;
		case "Sofa":
			setButtonColor(2);
			text.setText(info[2]);
			break;
		case "ArmChair":
			setButtonColor(3);
			text.setText(info[3]);
			break;
		case "Wardrobe":
			setButtonColor(4);
			text.setText(info[4]);
			break;
		case "Light":
			setButtonColor(5);
			text.setText(info[5]);
			break;
		case "TV":
			setButtonColor(6);
			text.setText(info[6]);
			break;
		}

	}
}
