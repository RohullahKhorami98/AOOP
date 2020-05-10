package Project;

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
