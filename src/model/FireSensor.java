package model;

// fireSensor is a subclass of Sensor
public class FireSensor extends Sensor{
	public FireSensor()
 	{
 		super();

 	}
	
	// return the fire Icon file names
	public String[] getIcon()
	{
		String[] fireIcon={"fire Off.png","fire on.png","fire alert.png"};
			
		return fireIcon;
	}


}
