package model;

public class Sensor 
{
	private String sensorID;
	//sensor itselg doesn't need t oknow its group info
	private String sensorType;

	private boolean automation;

	public Sensor(String ID)
	{
		sensorID = ID ;

		this.automation = false;

	}
	String getSensorID()
	{
		return sensorID;
	}
	
}