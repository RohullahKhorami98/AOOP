package Project;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

public class Frame extends Buttons {
	static JFrame frame;
	static JPanel ButtonPanel;
	static ShopList textlist;
	static JTextArea text;
	static Information info ;
	static JPanel menuPanel;
	static Drawing d;
	static Oberver_machine observer;
	
	public Frame() {
		
		frame = new JFrame();
		d = new Drawing();
		info = new Information();
		observer = new Oberver_machine();
		menuPanel = new JPanel();
		ButtonPanel = new JPanel();
		text = new JTextArea(info.info[0]);
		textlist = new ShopList();
		frame.setSize(800, 800);
		text.setPreferredSize(new Dimension(100, 100));
		text.setBorder(BorderFactory.createLineBorder(Color.decode("#998A3F"), 2));
		frame.add(d, BorderLayout.CENTER);
		frame.add(text, BorderLayout.SOUTH);
		frame.add(textlist, BorderLayout.WEST);
		ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.Y_AXIS));
		ButtonPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#998A3F"), 2));
		frame.add(ButtonPanel, BorderLayout.LINE_END);
		ButtonClick();
		for (int i = 0; i < size; i++) {
			ButtonPanel.add(button[i]);
			ButtonPanel.add(Box.createVerticalGlue());
		}
		Menu b = new Menu();
		b.setBorder(BorderFactory.createLineBorder(Color.decode("#998A3F"), 2));
		frame.setJMenuBar(b);
		observer.attach(textlist);
		observer.attach(d);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}