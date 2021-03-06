
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

/**
 * @author Rohullah Khorami & William Wahlberg
 * <h1> Menu</h1>
 * <p1> Generates a custom Menu, in menu there are File JMenu and Help JMenu
 * in JMenu File there are save close open and export as list options 
 * you can save your desgin as coordinates and also as a list and you can open them by
 * open option as a workspace on roomsketcher. Help menu helps you to search on google 
 * it is just an extra option.</p1>
 */

@SuppressWarnings("serial")
public class Menu extends JMenuBar{

	static JMenu File;
	static JMenu HELP;
	static JMenuItem Save;
	static JMenuItem close;
	static JMenuItem open;
	static JMenuItem search;
	static JMenuItem Export;

	static ArrayList<Labelpos> LabelposList;

	public Menu() {
		
		new JMenuBar();
		menu_bar();
		add(File);
		add(HELP);
		LabelposList = new ArrayList<Labelpos>();

	}

	public void menu_bar() {
		File = new JMenu("File");
		HELP = new JMenu("Help");
		

	

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
					JOptionPane.showMessageDialog(null, "Saved!", null ,JOptionPane.INFORMATION_MESSAGE);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

			    }
			}
		});
		File.add(Save);

		
		Export = new JMenuItem("Export list");
		Export.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] furTypes = new int[6];
				for(Labelpos i: Drawing.labellist) {
					if(i.getName().equals("Chair"))
						furTypes[0]++;
					if(i.getName().equals("Bed"))
						furTypes[1]++;
					if(i.getName().equals("soffa"))
						furTypes[2]++;
					if(i.getName().equals("Light"))
						furTypes[3]++;
					if(i.getName().equals("TV"))
						furTypes[4]++;
					if(i.getName().equals("Wardrobe"))
						furTypes[5]++;
				}
				JFileChooser fileChooser = new JFileChooser();
			    int retval = fileChooser.showSaveDialog(null);
			    
			    if (retval == JFileChooser.APPROVE_OPTION) {
			    	
			      File file = fileChooser.getSelectedFile();
			      String list="";
			      
			      if(furTypes[0]>0) 
			    	  list += furTypes[0] + "x Chair\n";
			      if(furTypes[1]>0) 
			    	  list += furTypes[1] + "x Bed\n";
			      if(furTypes[2]>0) 
			    	  list += furTypes[2] + "x Soffa\n";
			      if(furTypes[3]>0) 
			    	  list += furTypes[3] + "x Light\n";
			      if(furTypes[4]>0) 
			    	  list += furTypes[4] + "x TV\n";
			      if(furTypes[5]>0) 
			    	  list += furTypes[5] + "x Wardrobe\n";
				  
				  try {
					PrintWriter out = new PrintWriter(file.getPath());
					out.println(list);
					out.close();
					JOptionPane p = new JOptionPane();
					p.showMessageDialog(null, "Saved!", null ,p.INFORMATION_MESSAGE);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

			    }
			}
		});
		File.add(Export);
		
		
		close = new JMenuItem("Close");
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ("Close".equals(e.getActionCommand())) {
					int dialog = JOptionPane.showConfirmDialog(null, "Are you sure?", "Warning",JOptionPane.YES_NO_OPTION);
					if (dialog == JOptionPane.YES_OPTION) {
						System.exit(0);
					}  else {
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