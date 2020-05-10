package Project;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ShopList extends JPanel implements Obeserver{
	ArrayList<Labelpos> templist;
	public ShopList() {
		setPreferredSize(new Dimension(100, 100));
		setBorder(BorderFactory.createLineBorder(Color.decode("#998A3F"), 2));
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		templist = new ArrayList<>();
	}

	@Override
	public void update(ArrayList<Labelpos> list) {
		templist = list;
		removeAll();
		for(Labelpos temp : list) {
			add(new JLabel (temp.getName()));
		}
		
	}
}
