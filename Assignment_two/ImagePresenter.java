package FrameWork;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

public class ImagePresenter extends Presenter implements ActionListener {
	static String pic_s = "pic_start.png";
	String start_text = "Slide Task";

	static String end = "end.jpg";
	String end_text = "End of slide";

	static String[] ImagePath = { "pic1.jpg", "pic2.jpg", "pic3.jpg", "pic4.jpg", "pic5.jpg", "pic6.jpg", "pic7.png",
			"pic8.jpg", "pic9.jpg", "pic10.jpg" };
	String[] infoText = { "Tree and Views ", "Don't play with sharks!", "Green eyes are symbol of alianess ",
			"Stay Home, Save the Planet", "Computer Tek", "Flowers are beautiful", "Space is huge", "COVID-19",
			"Eat well", "Sweden is great" };
	static int currentImage = 0;

	static JLabel label = new JLabel();

	@Override
	public void northButtonPressed() {

		textArea.setText(start_text);
		label.setIcon(
				new ImageIcon("/Users/rohullahkhorami/Desktop/AOOP/Assginement/2nd_assign/src/FrameWork/" + pic_s));
		currentImage++;

	}

	@Override
	public void southButtonPressed() {

		textArea.setText(end_text);
		label.setIcon(new ImageIcon("/Users/rohullahkhorami/Desktop/AOOP/Assginement/2nd_assign/src/FrameWork/" + end));
		currentImage++;

	}

	@Override
	public void eastButtonPressed() {
		currentImage++;
		textArea.setText(infoText[currentImage % infoText.length]);
		createCenterComponent();
	}

	@Override
	public void westButtonPressed() {
		currentImage--;
		if (currentImage == -1) {
			currentImage = ImagePath.length;
		}

		textArea.setText(infoText[currentImage % infoText.length]);

		createCenterComponent();

	}

	@Override
	public Component createCenterComponent() {

		label.setIcon(new ImageIcon("/Users/rohullahkhorami/Desktop/AOOP/Assginement/2nd_assign/src/FrameWork/"
				+ ImagePath[currentImage % ImagePath.length]));
		label.repaint();
		return label;
	}

}
