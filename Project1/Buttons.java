package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * 
 * @author Rohullah khorami & William Wahlberg
 * <h3> Buttons</h3>
 * <p> This class generates buttons and ActionListeners for furniture.
 * action listener calls positions to get input from user and then adds
 * a new Labelpos to the Labellist in observer_machine</p>
 */
public abstract class Buttons extends JButton{

	JButton[] button;
	public int size = 6;
	Positions p;
	int id;
	Information info = new Information();
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
				if (p.check()) {
					Frame.text.setText(info.info[1]);
					Labelpos temp = new Labelpos(0, 0, p.h, p.w, p.sc, p.shape, "Chair", id);
					id++;
					Frame.observer.add_to_labellist(temp);
				}
			}
		});
		button[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = new Positions();
				if (p.check()) {
					Frame.text.setText(info.info[2]);
					Labelpos temp = new Labelpos(0, 0, p.h, p.w, p.sc, p.shape, "Bed", id);
					id++;
					Frame.observer.add_to_labellist(temp);
				}
			}
		});
		button[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = new Positions();
				if (p.check()) {
					Frame.text.setText(info.info[3]);
					Labelpos temp = new Labelpos(0, 0, p.h, p.w, p.sc, p.shape, "soffa", id);
					id++;
					Frame.observer.add_to_labellist(temp);

				}
			}
		});
		button[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = new Positions();
				if (p.check()) {
					Frame.text.setText(info.info[4]);
					Labelpos temp = new Labelpos(0, 0, p.h, p.w, p.sc, p.shape, "Light", id);
					id++;
					Frame.observer.add_to_labellist(temp);

				}
			}
		});
		button[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = new Positions();
				if (p.check()) {
					Frame.text.setText(info.info[5]);
					Labelpos temp = new Labelpos(0, 0, p.h, p.w, p.sc, p.shape, "TV", id);
					id++;
					Frame.observer.add_to_labellist(temp);
				}

			}
		});
		button[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = new Positions();
				if (p.check()) {
					Frame.text.setText(info.info[6]);
					Labelpos temp = new Labelpos(0, 0, p.h, p.w, p.sc, p.shape, "Wardrobe", id);
					id++;
					Frame.observer.add_to_labellist(temp);

				}

			}
		});
	}
}
