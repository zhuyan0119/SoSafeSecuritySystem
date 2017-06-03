package sensorview;

import javax.swing.*;

public class SingleFireSensorView extends SingleSensorVIew{
	
	/*
	 private ImageIcon sensorOff = getResizeImageIcon("fire Off.jpeg", LABEL_HEIGHT-25, LABEL_WIDTH-25);
	 private ImageIcon sensorOn = getResizeImageIcon("fire On.png", LABEL_HEIGHT-25, LABEL_WIDTH-25);
	 private ImageIcon sensorAlert = getResizeImageIcon("sprinklerOn.png", LABEL_HEIGHT-25, LABEL_WIDTH-25);
	 */
	
	//constructor SingleFireSensorView
	public SingleFireSensorView(String sensorId, String text, String group, int locationX, int locationY) {	
		super(sensorId, text, group, locationX, locationY,"fire Off.jpeg","fire On.png","sprinklerOn.png");	
	}
}
