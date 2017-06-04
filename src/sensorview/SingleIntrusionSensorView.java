package sensorview;

import javax.swing.ImageIcon;

public class SingleIntrusionSensorView extends SingleSensorVIew {
		
	// add bell_off, bell_on and bell_Alert files to use superclass constructor
	// add Intrusion imagines to icon
	public SingleIntrusionSensorView(String sensorId, String text, String group, int locationX, int locationY) {
		super(sensorId, text, group, locationX, locationY,"bell off.png","bell On.jpg","sprinklerOn.png");
		// TODO Auto-generated constructor stub
	}

}
