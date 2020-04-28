package FrameWork;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Presenter extends java.applet.Applet implements ActionListener  {

	public abstract java.awt.Component createCenterComponent();

	public void showText(String text) {
		
	}

	public abstract void northButtonPressed();

	public abstract void eastButtonPressed();

	public abstract void southButtonPressed();

	public abstract void westButtonPressed();
}
