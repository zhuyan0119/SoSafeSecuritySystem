package model;

public class IntruderSensor extends Sensor {
	public IntruderSensor()
	{
		
	}
	
	public String[] getIcon(){
		String[] intruderIcon = {"bell off.png","bell on.png","bell alert.png"};
		return intruderIcon;
	}
}
