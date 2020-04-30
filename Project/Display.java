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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class Display extends Button {

	JFrame frame;
	static Room panel;
	JTextArea text;
	JPanel buttonpanel;
	String info[] = { "Chiar", "Table", "Sofa", "ArmChair", "WarDrope", "light", "TV" };
	static String image_list[] = {};
	static int currentImage;
	
	ArrayList<Furniture> FurnitureList = new ArrayList<Furniture>();

	public Display() {
		panel = new Room();
		frame = new JFrame();
		frame.setSize(1400, 1000);
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
		frame.setJMenuBar(new Menu_Bar());
		//panel.setBackground(Color.decode("#64646464"));
		panel.setBackground(Color.red);
		frame.add(panel,BorderLayout.CENTER);
		
		
		initButtons();
		for (int i = 0; i < nrOfButtons; i++) {
			buttonpanel.add(buttons[i]);
			buttonpanel.add(Box.createVerticalGlue());

		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		String event = e.getActionCommand();

		FurnitureList.add(new Furniture(event));
		

	}
}
