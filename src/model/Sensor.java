package model;

public abstract class Sensor 
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

	public int getSensorID(){
		return sensorID;
	}
	public String getSensorType()
	{
		return sensorType;
	}
	
	abstract public String[] getIcon();
	
}