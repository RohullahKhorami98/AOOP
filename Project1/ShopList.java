package Project1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * @author Rohullah khorami & William Wahlberg
 * <h1>ShopList</h1>
 * <p1> Shoplist class implements obeserver and generates a JPanel 
 * in order to make a list of shoping items. In this class there is a temp list which has list of 
 * objects. Right and left click is also implemented in this class. At the end it displays visibility 
 * of frame for refreshing the removed items from list.<p/1>
 */

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
			JLabel label = new JLabel(temp.getName());
			label.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					if(SwingUtilities.isLeftMouseButton(e)) {
						Frame.d.check_updater(temp.getId());
					}
					else if(SwingUtilities.isRightMouseButton(e)){
						Frame.observer.Remove_id(temp.getId());
						System.out.println("delete");
					}
				}
				
			});
				add(label);
				
				
		}
		repaint();
		Frame.frame.setVisible(true);
	}
	

}