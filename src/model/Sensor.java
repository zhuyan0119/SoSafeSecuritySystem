package model;

import java.util.*;


public abstract class Sensor extends Observable
{
	
	private static int nextID = 0;

	private int  sensorID;
	private String sensorType;
	private boolean automation;
	private boolean isOn;


	public Sensor()
	{
		sensorID = nextID;
		nextID ++;

		this.automation = false;

	}

	public int getSensorID()
	{
		return sensorID;
	}
	public String getSensorType()
	{
		return sensorType;
	}
	public boolean getIsOn()
	{
		return isOn;
	}
	public void setIsOn(boolean isOn)
	{
		this.isOn = isOn;

		setChanged();
	    // notify el has changed
	    notifyObservers();	

	}
	
	abstract public String[] getIcon();
	
	
}