import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Room extends Canvas{

	String name [] = {"table.png"};	
	
	
	public Room() {
		
	}
	
	public void paint(Graphics g) {
		try {
		
		
		BufferedImage img = ImageIO.read(new File("/Users/rohullahkhorami/Desktop/AOOP/Assginement/Project/src/" + name[0]));
		
		g.drawImage(img,0,0,null);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
