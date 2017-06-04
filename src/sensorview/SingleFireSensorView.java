package sensorview;

import javax.swing.*;

import model.SensorGroup;

public class SingleFireSensorView extends SingleSensorVIew{
	
	// add fire imagines to icon
	//constructor SingleFireSensorView, add fire_off , fire_on and fire_alert filename to super class constructor
	
	public SingleFireSensorView(String sensorId, SensorGroup text, String group, int locationX, int locationY, String[] filename) {	
		super(sensorId, group, text, locationX, locationY,filename);	
	}
	
	
}
