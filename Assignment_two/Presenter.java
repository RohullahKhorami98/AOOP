package FrameWork;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings({ "serial", "deprecation" })
public abstract class Presenter extends java.applet.Applet implements ActionListener {

	JTextArea textArea;
	static JFrame frame;

	public abstract java.awt.Component createCenterComponent();

	public abstract void northButtonPressed();

	public abstract void eastButtonPressed();

	public abstract void southButtonPressed();

	public abstract void westButtonPressed();

	public Presenter() {

		frame = new JFrame();
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		JPanel buttons = new JPanel();
		buttons.setLayout(new BorderLayout());
		JButton north = new JButton("Start");
		JButton east = new JButton("Right");
		JButton south = new JButton("End");
		JButton west = new JButton("Left");

		frame.add(createCenterComponent());

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
		textArea.setText("Lets Start");
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
}
