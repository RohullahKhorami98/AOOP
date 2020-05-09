package Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;



class Drawing extends JPanel {
	ArrayList<Labelpos> labellist;
	private int squareX;
	private int squareY;
	private int squareW;
	private int squareH;

	public Drawing() {
		labellist= new ArrayList<>();
		// setBorder(BorderFactory.createLineBorder(Color.red));

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				moveSquare(e.getX(), e.getY());
			}
		});

		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				moveSquare(e.getX(), e.getY());
			}
		});

	}

	private void moveSquare(int x, int y) {
		int OFFSET = 1;
		if ((squareX != x) || (squareY != y)) {
			repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
			squareX = x;
			squareY = y;
			repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(squareW, squareH);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Labelpos temp:labellist) {
		// g.drawString("This is my custom Panel!", 10, 20);
		g.setColor(Color.RED);
		g.fillRect(temp.getX(),temp.getY(),temp.getWidth(),temp.getHeight());
		System.out.println(this.squareW);
		g.setColor(Color.BLACK);
		g.drawRect(temp.getX(),temp.getY(),temp.getWidth(),temp.getHeight());
		}
	}
	public int getSquareX() {
		return squareX;
	}

	public void setSquareX(int squareX) {
		this.squareX = squareX;
	}

	public int getSquareY() {
		return squareY;
	}

	public void setSquareY(int squareY) {
		this.squareY = squareY;
	}

	public int getSquareW() {
		return squareW;
	}

	public void setSquareW(int squareW) {
		this.squareW = squareW;

	}

	public int getSquareH() {
		return squareH;
	}

	public void setSquareH(int squareH) {
		this.squareH = squareH;

	}public void insert(int x, int y,int w,int h) {
		Labelpos temp = new Labelpos(x,y,w,h);

		labellist.add(temp);
		addall();
	}
	
	public void addall() {
		for (Labelpos temp : labellist) {
			
			repaint();
			//repaint(temp.getX(),temp.getY(),temp.getWidth(),temp.getHeight());

		}
		repaint();
	}

}
