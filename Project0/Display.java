import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Display extends Button {

	static JFrame frame;
	static Room panel;
	JTextArea text;
	JPanel buttonpanel;
	public Display() {
		panel = new Room();
		
		frame = new JFrame();
		frame.setSize(1400, 1000);
		frame.setLayout(new BorderLayout());
		buttonpanel = new JPanel();
		buttonpanel.setSize(200, 800);
		buttonpanel.setLayout(new BoxLayout(buttonpanel, BoxLayout.Y_AXIS));
		buttonpanel.setBorder(BorderFactory.createLineBorder(Color.decode("#998A3F"), 2));

		frame.add(buttonpanel, BorderLayout.LINE_END);

		text = new JTextArea();
		text.setBorder(BorderFactory.createLineBorder(Color.decode("#998A3F"), 2));

		text.setPreferredSize(new Dimension(100, 100));
		text.setEditable(true);

		frame.add(text, BorderLayout.PAGE_END);
		Menu_Bar b = new Menu_Bar();
		b.setBorder(BorderFactory.createLineBorder(Color.decode("#998A3F"), 2));
		frame.setJMenuBar(b);
		
		frame.add(panel, BorderLayout.CENTER);
		initButtons();
		for (int i = 0; i < nrOfButtons; i++) {
			buttonpanel.add(buttons[i]);
			buttonpanel.add(Box.createVerticalGlue());
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public static void setlabel(JLabel label) {
		panel.add(label);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}
}