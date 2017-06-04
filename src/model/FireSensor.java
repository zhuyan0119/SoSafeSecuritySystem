package model;

public class FireSensor extends Sensor{
	public FireSensor()
 	{
 		super();
 		//sensorType = type;
 	}
	
	// return the fire Icon file names
	public String[] getIcon(){
		String[] fireIcon={"fire Off.jpeg","fire On.png","fire alert.png"};
		return fireIcon;
	}


}
