package FrameWork;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Display extends Presenter implements ActionListener {

	static String pic_s = "pic_start.png";
	String start_text = "Slide Task";

	static String end = "end.jpg";
	String end_text = "End of slide";

	static String[] ImagePath = { "pic1.jpg", "pic2.jpg", "pic3.jpg", "pic4.jpg", "pic5.jpg", "pic6.jpg", "pic7.png",
			"pic8.jpg", "pic9.jpg", "pic10.jpg" };
	String[] infoText = { "Tree and Views ", "Don't play with sharks!", "Green eyes are symbol of alianess ",
			"Stay Home, Save the Planet", "Computer Tek", "Flowers are beautiful", "Space is huge", "COVID-19",
			"Eat well", "Sweden is great" };
	static int currentImage = 0;

	JTextArea textArea;
	static JFrame frame;

	static JLabel label = new JLabel();

	public Display() {

		frame = new JFrame();

		ImagePresenter.showImage(ImagePath[currentImage]);
		JPanel bottom = new JPanel();

		bottom.setLayout(new BorderLayout());
		JPanel buttons = new JPanel();
		buttons.setLayout(new BorderLayout());
		JButton north = new JButton("Start");
		JButton east = new JButton("Right");
		JButton south = new JButton("End");
		JButton west = new JButton("Left");

		label.setIcon(
				new ImageIcon("/Users/rohullahkhorami/Desktop/AOOP/Assginement/2nd_assign/src/FrameWork/" + pic_s));

		frame.add(label);

		north.addActionListener(this);
		east.addActionListener(this);
		south.addActionListener(this);
		west.addActionListener(this);
		buttons.add(north, BorderLayout.PAGE_START);
		buttons.add(east, BorderLayout.LINE_END);
		buttons.add(south, BorderLayout.PAGE_END);
		buttons.add(west, BorderLayout.LINE_START);
		buttons.setPreferredSize(new Dimension(200, 100));
		bottom.add(buttons, BorderLayout.LINE_START);
		frame.add(bottom, BorderLayout.PAGE_END);

		textArea = new JTextArea();
		textArea.setColumns(16);
		textArea.setEditable(false);
		textArea.setText(start_text);
		bottom.add(textArea, BorderLayout.CENTER);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String event = e.getActionCommand();
		switch (event) {
		case "Start":
			northButtonPressed();

			break;
		case "Right":
			eastButtonPressed();

			break;
		case "End":
			southButtonPressed();

			break;
		case "Left":
			westButtonPressed();
			break;
		}

	}

	@Override
	public Component createCenterComponent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void northButtonPressed() {

		textArea.setText(start_text);
		label.setIcon(
				new ImageIcon("/Users/rohullahkhorami/Desktop/AOOP/Assginement/2nd_assign/src/FrameWork/" + pic_s));
		label.repaint();
		currentImage++;

	}

	@Override
	public void southButtonPressed() {

		textArea.setText(end_text);
		label.setIcon(new ImageIcon("/Users/rohullahkhorami/Desktop/AOOP/Assginement/2nd_assign/src/FrameWork/" + end));
		label.repaint();
		currentImage++;

	}

	@Override
	public void eastButtonPressed() {
		currentImage++;
		textArea.setText(infoText[currentImage % infoText.length]);
		label.setIcon(new ImageIcon("/Users/rohullahkhorami/Desktop/AOOP/Assginement/2nd_assign/src/FrameWork/"
				+ ImagePath[currentImage % ImagePath.length]));
		label.repaint();

		// TODO Auto-generated method stub

	}

	@Override
	public void westButtonPressed() {
		currentImage--;
		if (currentImage == -1) {
			currentImage = ImagePath.length;
		}
		textArea.setText(infoText[currentImage % infoText.length]);
		label.setIcon(new ImageIcon("/Users/rohullahkhorami/Desktop/AOOP/Assginement/2nd_assign/src/FrameWork/"
				+ ImagePath[currentImage % ImagePath.length]));
		

		label.repaint();

	}

	public static BufferedImage Pic() throws IOException {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("/Users/rohullahkhorami/Desktop/AOOP/Assginement/2nd_assign/src/FrameWork/"
					+ ImagePath[currentImage]));
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
		label.setIcon(new ImageIcon(pic));
		label.repaint();

	}
}
