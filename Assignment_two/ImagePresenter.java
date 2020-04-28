package FrameWork;

import java.awt.Component;

import javax.swing.JFrame;

public abstract class ImagePresenter extends Presenter  {
	
	
	public static void showImage(String filename) {
	}

	
	public Component createCenterComponent() {
		JFrame f  = null;
		return f;
	}
	
	
}
