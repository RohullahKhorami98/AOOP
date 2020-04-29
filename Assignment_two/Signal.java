package Signal;

import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;

public class Signal {
	private double amplitude;
	private final int SAMPLING = 1000;
	private ArrayList<SignalObserver> myObservers;

	public void addObserver(SignalObserver s) {
		myObservers.add(s);
	}

	public Signal() {
		
		DefaultSampler ds = new DefaultSampler();
		myObservers = new ArrayList<SignalObserver>();
		Timer t = new Timer(SAMPLING, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextValue(ds.read());
			}
		});
		t.start();
	}
	
	private void nextValue(double x) {
		amplitude = x;
		for (SignalObserver so : myObservers) {
			so.updateSignal(amplitude);
		}		
	}
}