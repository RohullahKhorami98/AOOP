package Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public abstract class Buttons extends JButton implements ActionListener {

	JButton[] button;
	public int size = 6;
	Drawing d;
	Positions p;

	public Buttons() {

	}

	public void ButtonClick() {
		button = new JButton[size];
		d = new Drawing();

		button[0] = new JButton("Chair");
		button[1] = new JButton("Bed");
		button[2] = new JButton("Soffa");
		button[3] = new JButton("Light");
		button[4] = new JButton("TV");
		button[5] = new JButton("Wardrobe");

		button[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = new Positions();
				Frame.text.setText("Chair");
				d.insert(0, 0, p.h, p.w , p.s);
				Frame.frame.add(d);

			}
		});
		button[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = new Positions();
				Frame.text.setText("Bed");
				d.insert(0, 0, p.h, p.w , p.s);
				Frame.frame.add(d);

			}
		});
		button[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = new Positions();
				Frame.text.setText("Soffa");
				d.insert(0, 0, p.h, p.w, p.s);
				Frame.frame.add(d);

			}
		});
		button[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = new Positions();
				Frame.text.setText("Light");
				d.insert(0, 0, p.h, p.w , p.s);
				Frame.frame.add(d);

			}
		});
		button[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = new Positions();
				Frame.text.setText("TV");
				d.insert(0, 0, p.h, p.w , p.s);
				Frame.frame.add(d);

			}
		});
		button[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.text.setText("Wardrobe");
				p = new Positions();
				d.insert(0, 0, p.h, p.w, p.s );
				Frame.frame.add(d);

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
