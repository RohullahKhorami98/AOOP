package Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public abstract class Buttons extends JButton implements ActionListener {

	JButton[] button;
	public int size = 6;
	Positions p;
	int id; 

	public Buttons() {

	}

	public void ButtonClick() {
		button = new JButton[size];
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
				Labelpos  temp = new Labelpos(0, 0, p.h, p.w , p.s, p.shape , "Chair" , id);
				id++;
				Frame.observer.set_label_list(temp);
				

			}
		});
		button[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = new Positions();
				Frame.text.setText("Bed");
				Labelpos  temp = new Labelpos(0, 0, p.h, p.w , p.s, p.shape , "Bed" , id);
				id++;
				Frame.observer.set_label_list(temp);
				

			}
		});
		button[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = new Positions();
				Frame.text.setText("Soffa");
				Labelpos  temp = new Labelpos(0, 0, p.h, p.w , p.s, p.shape , "soffa",id);
				id++;
				Frame.observer.set_label_list(temp);
				

			}
		});
		button[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = new Positions();
				Frame.text.setText("Light");
				Labelpos  temp = new Labelpos(0, 0, p.h, p.w , p.s, p.shape , "Light",id);
				id++;
				Frame.observer.set_label_list(temp);
				

			}
		});
		button[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = new Positions();
				Frame.text.setText("TV");
				Labelpos  temp = new Labelpos(0, 0, p.h, p.w , p.s, p.shape , "TV",id);
				id++;
				Frame.observer.set_label_list(temp);
				

			}
		});
		button[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.text.setText("Wardrobe");
				p = new Positions();
				Labelpos  temp = new Labelpos(0, 0, p.h, p.w , p.s, p.shape , "Wardrobe",id);
				id++;
				Frame.observer.set_label_list(temp);
				
				

			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			
	}
}