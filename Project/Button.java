import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public abstract class Button implements ActionListener {

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
				Display.setlabel(new Chair());
			}
		});
		buttons[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Display.setlabel(new Table());
			}
		});
		buttons[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Display.setlabel(new Sofa());
			}
		});
		buttons[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Display.setlabel(new ArmChair());
			}
		});
		buttons[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Display.setlabel(new Wardrobe());
			}
		});
		buttons[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Display.setlabel(new Light());
			}
		});
		buttons[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Display.setlabel(new TV());
			}

		});

		buttons[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Display.setlabel(new Bed());

			}

		});
		buttons[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Display.setlabel(new Carpet());

			}

		});
		buttons[9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Display.setlabel(new DTable());

			}

		});

	}

}
