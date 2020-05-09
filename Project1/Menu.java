package Project;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class Menu extends JMenuBar {

	static JMenu File;
	static JMenu HELP;
	static JMenu Edit;
	static JMenuItem Action;
	static JMenuItem min;
	static JMenuItem max;
	static JMenuItem Save;
	static JMenuItem close;
	static JMenuItem open;
	static JMenuItem search;

	public Menu() {

		new JMenuBar();
		menu_bar();
		add(File);
		add(Edit);
		add(HELP);

	}

	public void menu_bar() {

		Action = new JMenuItem("Action");
		min = new JMenuItem("Minimize");
		max = new JMenuItem("Maximize");

		File = new JMenu("File");
		HELP = new JMenu("Help");
		Edit = new JMenu("Edit");

		Edit.add(min);
		Edit.add(max);

		open = new JMenuItem("Open");
		open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser select = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
				select.setFileFilter(filter);
				int returnVal = select.showOpenDialog(getParent());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					select.getSelectedFile().getName();
				}
			}

		});
		File.add(open);

		Save = new JMenuItem("Save");
		Save.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				BufferedImage work = null;
				try {
					work = new Robot().createScreenCapture(Frame.menuPanel.bounds());
				} catch (AWTException e1) {

					e1.printStackTrace();
				}
				Graphics2D graphics2D = work.createGraphics();
				Frame.menuPanel.paint(graphics2D);
				try {
					int dialog = JOptionPane.showConfirmDialog(null, "Are you sure you want to save?", "Save",
							JOptionPane.YES_NO_OPTION);
					if (dialog == JOptionPane.YES_OPTION) {
						ImageIO.write(work, "jpeg", new java.io.File("First" + (int )(Math.random() * 100) + ".jpeg"));
					} else {
						remove(dialog);
					}
				} catch (Exception e1) {
				}
			}
		});
		File.add(Save);

		close = new JMenuItem("Close");
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ("Close".equals(e.getActionCommand())) {
					int dialog = JOptionPane.showConfirmDialog(null, "Are you sure?", "Warning",
							JOptionPane.YES_NO_OPTION);
					if (dialog == JOptionPane.YES_OPTION) {
						System.exit(0);
					} else {
						remove(dialog);
					}
				}
			}
		});
		File.add(close);

		search = new JMenuItem("Go to web");
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI("http://google.com"));
				} catch (IOException | URISyntaxException e1) {

					e1.printStackTrace();
				}

			}

		});

		HELP.add(search);
	}
}
