import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class Button implements ActionListener{
	
	
	
	
	
	int nrOfButtons = 7;
	JButton[] buttons;
	
		
	
	public void initButtons() {
		buttons = new JButton[nrOfButtons];
		
		buttons[0] = new JButton("Chair");
		buttons[0].setForeground(Color.red);
		
		buttons[1] = new JButton("Table");
		buttons[1].setForeground(Color.green);
		
		buttons[2] = new JButton("Sofa");
		buttons[2].setForeground(Color.decode("#FF0080"));
		
		buttons[3] = new JButton("ArmChair");
		buttons[3].setForeground(Color.orange);
		
		buttons[4] = new JButton("Wardrobe");
		buttons[4].setForeground(Color.decode("#6E6E6E"));
		
		buttons[5] = new JButton("Light");
		buttons[5].setBackground(Color.cyan);
		
		buttons[6] = new JButton("TV");
		
		buttons[0].addActionListener(this);
		buttons[1].addActionListener(this);
		buttons[2].addActionListener(this);
		buttons[3].addActionListener(this);
		buttons[4].addActionListener(this);
		buttons[5].addActionListener(this);
		buttons[6].addActionListener(this);
		
		
		
	}
	
	public void setButtonColor(int set) {
		
		for (int i = 0; i < nrOfButtons; i++) {
			buttons[i].setBackground(Color.white);
			
		}
		buttons[set].setBackground(Color.RED);
		
	}

	
	
}
