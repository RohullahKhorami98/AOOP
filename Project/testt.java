package Project;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
class testt
{
    //Driver function
    public static void main(String args[])
    {
         //Create a frame
	 JFrame frame=new JFrame("Borders around Buttons");
	 frame.setSize(500,500);
	 frame.setLayout(null);
	 frame.setBackground(Color.white);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 //Create push buttons
	 JButton[] button=new JButton[5];
	 for(int i=0;i<5;i++)
	 {
	     button[i]=new JButton("Button "+(i+1));
	     button[i].setBounds(210,i*75,100,50);
	     frame.add(button[i]);
	 }
	 //Create different borders
         LineBorder thin,thick;
         EtchedBorder raised,low;
         BevelBorder bevel;
	 thin=new LineBorder(Color.black,2);
	 thick=new LineBorder(Color.black,10);
	 raised=new EtchedBorder(EtchedBorder.RAISED,Color.black,Color.white);
	 low=new EtchedBorder(EtchedBorder.LOWERED,Color.black,Color.white);
	 bevel=new BevelBorder(BevelBorder.RAISED,Color.black,Color.white);
	 //Add borders to buttons
	 button[0].setBorder(thin);
	 button[1].setBorder(thick);
	 button[2].setBorder(raised);
	 button[3].setBorder(low);
	 button[4].setBorder(bevel);
	 //Display frame
	 frame.setVisible(true);
    }
}