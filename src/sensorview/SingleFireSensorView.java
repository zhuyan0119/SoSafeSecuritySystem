package sensorview;

import javax.swing.*;

public class SingleFireSensorView extends SingleSensorVIew{
	
	// add fire imagines to icon
	//constructor SingleFireSensorView, add fire_off , fire_on and fire_alert filename to super class constructor
	public SingleFireSensorView(String sensorId, String text, String group, int locationX, int locationY) {	
		super(sensorId, text, group, locationX, locationY,"fire Off.jpeg","fire On.png","fire alert.png");	
	}
}
