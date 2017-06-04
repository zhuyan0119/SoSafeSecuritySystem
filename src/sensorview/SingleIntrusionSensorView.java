package sensorview;

import javax.swing.ImageIcon;

import model.SensorGroup;

public class SingleIntrusionSensorView extends SingleSensorVIew {
		
	// add bell_off, bell_on and bell_Alert files to use superclass constructor
	// add Intrusion imagines to icon
	public SingleIntrusionSensorView(String sensorId, SensorGroup text, String group, int locationX, int locationY, String[] filename) {
		super(sensorId, group, text, locationX, locationY,filename);
		// TODO Auto-generated constructor stub
	}

}
