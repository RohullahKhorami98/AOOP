package Project;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Menu extends JMenuBar{

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
	static ArrayList<Labelpos> LabelposList;

	public Menu() {
		
		new JMenuBar();
		menu_bar();
		add(File);
		add(Edit);
		add(HELP);
		LabelposList = new ArrayList<Labelpos>();

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
				int returnValue = select.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					
					File selectedFile = select.getSelectedFile();
					Scanner sc;
					ArrayList<Labelpos> labellist = new ArrayList<Labelpos>();
					
					try {
						sc = new Scanner(selectedFile);
						while(sc.hasNext()) {
						labellist.add(new Labelpos(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt()));
					}
						
						Frame.observer.set_new_list(labellist);

					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		File.add(open);

		Save = new JMenuItem("Save");
		Save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String save = "";
				for(Labelpos i: Drawing.labellist) {
					save += i.getX();
					save += " " + i.getY();
					save += " " + i.getHeight();
					save += " " + i.getWidth();
					save += " " + i.getC();
					save += " " + i.getShape();
					save += " " + i.getName();
					save += " " + i.getId();
					save += "\n";
				}
				System.out.println(save);
				JFileChooser fileChooser = new JFileChooser();
			    int retval = fileChooser.showSaveDialog(null);
			    if (retval == JFileChooser.APPROVE_OPTION) {
			      File file = fileChooser.getSelectedFile();
			      
				  System.out.println(file.getPath());
				                                                   
				  
				  try {
					PrintWriter out = new PrintWriter(file.getPath());
					out.println(save);
					out.close();
					JOptionPane p = new JOptionPane();
					p.showMessageDialog(null, "Saved!", null ,p.INFORMATION_MESSAGE);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

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