package model;

public class IntruderSensor extends Sensor {
	public IntruderSensor(String ID)
	{
		super(ID);
	}
	
	public String[] getIcon(){
		String[] intruderIcon = {"bell off.png","bell On.jpg","bell alert.jpg"};
		return intruderIcon;
	}
}
