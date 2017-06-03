package model;

public class Sensor 
{
	private String sensorID;
	private String sensorGroup; 
	private String sensorType;

	private boolean automation;

	public Sensor(String ID, String group)
	{
		sensorID = ID ;
		sensorGroup = group;

		this.automation = false;

	}
	String getSensorID()
	{
		return sensorID;
	}
	String getSensorGroup()
	{
		return sensorGroup;
	}
}
/*
class FireSensor extends Sensor
{
 	super(Sensor);
}
class IntruderSensor extends Sensor
{
	super(Sensor);
}
*/
