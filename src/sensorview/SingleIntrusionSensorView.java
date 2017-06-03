package sensorview;

import javax.swing.ImageIcon;

public class SingleIntrusionSensorView extends SingleSensorVIew {
	
	// import imagines
	/*
	private ImageIcon sensorOff = getResizeImageIcon("bell off.png", LABEL_HEIGHT-25, LABEL_WIDTH-25);
	private ImageIcon sensorOn = getResizeImageIcon("bell On.jpg", LABEL_HEIGHT-25, LABEL_WIDTH-25);
	private ImageIcon sensorAlert = getResizeImageIcon("sprinklerOn.png", LABEL_HEIGHT-25, LABEL_WIDTH-25);
	*/
	
	// use superclass constructor
	public SingleIntrusionSensorView(String sensorId, String text, String group, int locationX, int locationY) {
		super(sensorId, text, group, locationX, locationY,"bell off.png","bell On.jpg","sprinklerOn.png");
		// TODO Auto-generated constructor stub
	}

}
