
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class Drawing extends JPanel implements Obeserver {
	static ArrayList<Labelpos> labellist;
	int checker = 0;
	Boolean firsttime = true;

	public Drawing() {
		labellist = new ArrayList<>();

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (labellist.size() != 0) {
					int x = labellist.get(checker).getWidth();
					int y = labellist.get(checker).getHeight();
					if (e.getX() + x < getWidth() && e.getY() + y < getHeight()) {
						moveSquare(e.getX(), e.getY());
					}
				}
			}
		});

		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (labellist.size() != 0) {
					int x = labellist.get(checker).getWidth();
					int y = labellist.get(checker).getHeight();

					if (e.getY() > 0 && e.getX() > 0 && e.getX() + x < getWidth() && e.getY() + y < getHeight()) {

						moveSquare(e.getX(), e.getY());
					}
				}
			}
		});

	}

	private void moveSquare(int x, int y) {

		int a = labellist.get(checker).getWidth();
		int b = labellist.get(checker).getHeight();
		int c = labellist.get(checker).getX();
		int d = labellist.get(checker).getY();

		int OFFSET = 1;
		if ((c != x) || (d != y)) {

			repaint(c, d, a + OFFSET, b + OFFSET);
			labellist.get(checker).setX(x);
			labellist.get(checker).setY(y);
			repaint(x, y, a + OFFSET, b + OFFSET);

		}
	}

	@SuppressWarnings("static-access")
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Labelpos temp : labellist) {
			boolean draw = true;
			
			// door collision
			if (temp.getX() + temp.getWidth() > 500) {
				if (temp.getY() > 268 && temp.getY() < 368)
					draw = false;
				if (temp.getY() + temp.getHeight() > 268 && temp.getY() + temp.getHeight() < 368)
					draw = false;
				if (temp.getY() < 268 && temp.getY() + temp.getHeight() > 368)
					draw = false;
			}
			// window collision
			if (temp.getY() < 75) {
				// Left window
				if (temp.getX() > 152 && temp.getX() < 252)
					draw = false;
				if (temp.getX() + temp.getWidth()> 152 && temp.getX() + temp.getWidth() < 252)
					draw = false;
				if (temp.getX() < 152 && temp.getX() + temp.getWidth() > 252)
					draw = false;
				
				// Right window
				if (temp.getX() > 382 && temp.getX() < 482)
					draw = false;
				if (temp.getX() + temp.getWidth()> 382 && temp.getX() + temp.getWidth() < 482)
					draw = false;
				if (temp.getX() < 382 && temp.getX() + temp.getWidth() > 482)
					draw = false;
			
			}
			

			if (draw) {
				if (temp.getC() == 1) { 
					if (temp.getShape() == 1) {
						g.setColor(Color.red);
						g.fillOval(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
						g.setColor(Color.BLACK);
						g.drawOval(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
					}
					if (temp.getShape() == 2) {
						g.setColor(Color.red);
						g.fillRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), 90, 180);
						g.setColor(Color.BLACK);
						g.drawRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), 90, 180);
					}
					if (temp.getShape() > 2) {
						g.setColor(Color.red);
						g.fillRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
						g.setColor(Color.BLACK);
						g.drawRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
					}
				}

				if (temp.getC() == 2) {
					if (temp.getShape() == 1) {
						g.setColor(Color.black);
						g.fillOval(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
						g.setColor(Color.BLACK);
						g.drawOval(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
					}
					if (temp.getShape() == 2) {
						g.setColor(Color.black);
						g.fillRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), 30, 30);
						g.setColor(Color.BLACK);
						g.drawRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), 30, 30);
					}
					if (temp.getShape() > 2) {
						g.setColor(Color.black);
						g.fillRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
						g.setColor(Color.BLACK);
						g.drawRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
					}
				}
				if (temp.getC() == 3) {
					if (temp.getShape() == 1) {
						g.setColor(Color.blue);
						g.fillOval(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
						g.setColor(Color.BLACK);
						g.drawOval(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
					}
					if (temp.getShape() == 2) {
						g.setColor(Color.blue);
						g.fillRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), 30, 30);
						g.setColor(Color.BLACK);
						g.drawRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), 30, 30);
					}
					if (temp.getShape() > 2) {
						g.setColor(Color.blue);
						g.fillRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
						g.setColor(Color.BLACK);
						g.drawRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
					}
				}
				if (temp.getC() == 4) {
					if (temp.getShape() == 1) {
						g.setColor(Color.green);
						g.fillOval(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
						g.setColor(Color.BLACK);
						g.drawOval(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
					}
					if (temp.getShape() == 2) {
						g.setColor(Color.green);
						g.fillRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), 30, 30);
						g.setColor(Color.BLACK);
						g.drawRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), 30, 30);
					}
					if (temp.getShape() > 2) {
						g.setColor(Color.green);
						g.fillRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
						g.setColor(Color.BLACK);
						g.drawRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
					}
				}
				if (temp.getC() == 5) {
					if (temp.getShape() == 1) {
						g.setColor(Color.gray);
						g.fillOval(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
						g.setColor(Color.BLACK);
						g.drawOval(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
					}
					if (temp.getShape() == 2) {
						g.setColor(Color.gray);

						g.fillRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), 30, 30);
						g.setColor(Color.BLACK);
						g.drawRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), 30, 30);
					}
					if (temp.getShape() > 2) {
						g.setColor(Color.gray);
						g.fillRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
						g.setColor(Color.BLACK);
						g.drawRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
					}
				}
				if (temp.getC() == 6) {
					if (temp.getShape() == 1) {
						g.setColor(Color.cyan);
						g.fillOval(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
						g.setColor(Color.BLACK);
						g.drawOval(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
					}
					if (temp.getShape() == 2) {
						g.setColor(Color.cyan);
						g.fillRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), 30, 30);
						g.setColor(Color.BLACK);
						g.drawRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), 30, 30);
					}
					if (temp.getShape() > 2) {
						g.setColor(Color.cyan);
						g.fillRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
						g.setColor(Color.BLACK);
						g.drawRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
					}
				}
				if (temp.getC() > 6) {
					if (temp.getShape() == 1) {
						g.setColor(Color.decode("#FF6BCE"));
						g.fillOval(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
						g.setColor(Color.BLACK);
						g.drawOval(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
					}
					if (temp.getShape() == 2) {
						g.setColor(Color.decode("#FF6BCE"));
						g.fillRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), 30, 30);

						g.setColor(Color.BLACK);
						g.drawRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), 30, 30);
					}
					if (temp.getShape() > 2) {
						g.setColor(Color.decode("#FF6BCE"));
						g.fillRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
						g.setColor(Color.BLACK);
						g.drawRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
					}

				}
			} else {
				JOptionPane p = new JOptionPane();
				p.showMessageDialog(null, "Can not place furniture infront of door!", "Error", p.ERROR_MESSAGE);
			}
		}

		g.setColor(Color.decode("#CC9B5D"));
		g.fillRect(582, 268, 10, 100);

		g.setColor(Color.decode("#87CDF9"));
		g.fillRect(382, 1, 100, 10);

		g.setColor(Color.decode("#87CDF9"));
		g.fillRect(152, 1, 100, 10);

	}

	public void insert() {

		addall();

		if (!firsttime) {
			checker = labellist.size() - 1;
		}
		firsttime = false;
	}

	public void addall() {
		for (Labelpos temp : labellist) {
			repaint();

		}
		repaint();
	}

	@Override
	public void update(ArrayList<Labelpos> list) {
		labellist = list;
		insert();
		repaint();
	}

	public void check_updater(int checking) {
		checker = checking;
	}
}