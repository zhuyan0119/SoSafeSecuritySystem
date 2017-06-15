package model;

// IntruderSensor is a subclass of Sensor
public class IntruderSensor extends Sensor {
	public IntruderSensor()
	{
		super();
	}
	
	// return Icon filenames
	public String[] getIcon(){
		String[] intruderIcon = {"bell off.png","bell on.png","bell alert.png"};
		return intruderIcon;
	}
}
