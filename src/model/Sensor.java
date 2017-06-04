package model;

public class Sensor 
{
	
	private static int nextID = 0;

	private int  sensorID;
	private String sensorType;
	private boolean automation;


	public Sensor()
	{
		sensorID = nextID;
		nextID ++;

		this.automation = false;

	}
	int getSensorID()
	{
		return sensorID;
	}
	String getSensorType()
	{
		return sensorType;
	}
	
}