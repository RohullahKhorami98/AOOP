import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JLabel;

public abstract class Button implements ActionListener {

	ArrayList<Labelpos> list = new ArrayList<>();

	public Button() {

	}

	int nrOfButtons = 10;
	JButton[] buttons;

	public void initButtons() {
		buttons = new JButton[nrOfButtons];

		buttons[0] = new JButton("   Chair    ");
		buttons[0].setForeground(Color.red);

		buttons[1] = new JButton("   Table   ");
		buttons[1].setForeground(Color.green);

		buttons[2] = new JButton("    Sofa    ");
		buttons[2].setForeground(Color.decode("#FF0080"));

		buttons[3] = new JButton("ArmChair");
		buttons[3].setForeground(Color.orange);

		buttons[4] = new JButton("Wardrobe");
		buttons[4].setForeground(Color.black);

		buttons[5] = new JButton("   Light   ");
		buttons[5].setForeground(Color.decode("#62CF1F"));

		buttons[6] = new JButton("      TV    ");
		buttons[6].setForeground(Color.magenta);

		buttons[7] = new JButton("     Bed    ");
		buttons[7].setForeground(Color.red);

		buttons[8] = new JButton("  Carpet  ");
		buttons[8].setForeground(Color.blue);

		buttons[9] = new JButton("D-Table");
		buttons[9].setForeground(Color.decode("#A01A9C"));

		buttons[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Furniture c = new Furniture("chair.png");
				Labelpos temp = new Labelpos(c, c.xp, c.yp);
				list.add(temp);
				for (Labelpos value : list) {
					System.out.println(value.getX() + " " + value.getY());
					Display.setlabel(value.getLabel());
					value.getLabel().update(value.getX() + c.xp, value.getY() + c.yp);
				}

			}
		});
		buttons[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Display.setlabel(new Furniture("table2.png"));

			}
		});
		buttons[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Display.setlabel(new Furniture("soffa.png"));
			}
		});
		buttons[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Display.setlabel(new Furniture("armchairleader.png"));
			}
		});
		buttons[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Display.setlabel(new Furniture("wardrobe.png"));
			}
		});
		buttons[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Display.setlabel(new Furniture("light.png"));
			}
		});
		buttons[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Display.setlabel(new Furniture("tv.png"));
			}

		});

		buttons[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Display.setlabel(new Furniture("bed.png"));

			}

		});
		buttons[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Display.setlabel(new Furniture("carpet.png"));

			}

		});
		buttons[9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Display.setlabel(new Furniture("diningtable.png"));

			}

		});

	}

}