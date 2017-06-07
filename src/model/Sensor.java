package model;

import java.util.*;


public abstract class Sensor extends Observable
{
	
	private static int nextID = 0;

	private int  sensorID;
	private String sensorType;
	
	public boolean automation;
	
	private int status; // 0 for OFF, 1 for ON ,  -1 for Alert!
	
	

	public Sensor()
	{
		status=0;//default sensor status is off
		sensorID = nextID;
		nextID ++;
		automation = false;

	}

	public int getSensorID()
	{
		return sensorID;
	}
	public String getSensorType()
	{
		return sensorType;
	}
	
	
	public boolean getAutomation()
	{
		return automation;
	}
	
	// change sensor status to ON
	public void setSensorOn(){
		this.status = 1;
		setChanged();
	    // notify el has changed
	    notifyObservers();	
	}
	
	//change sensor status to OFF
	public void setSensorOff(){
		this.status = 0;
		setChanged();
	    // notify el has changed
	    notifyObservers();	
	}
	
	// change sensor status to alert
	public void setOnSensorAlert(){
		if (this.status==1) //if sensor is on, then it can give alert
			this.status = -1;
		setChanged();
	    // notify el has changed
	    notifyObservers();	
	}
	
	public void setOffSensorAlert(){
		if(this.status==-1) // if sensor is on alert, then it can be set off
			this.status=1;
		setChanged();
	    // notify el has changed
	    notifyObservers();	
	}
	
	public int getstatus(){
		return status;
	}
	
	public void observestatus()
	{
		this.status = status;

		setChanged();
	    // notify el has changed
	    notifyObservers();	

	}
	
	
	/*
	// observable of sensor status ON or OFF
	public void setIsOn(boolean isOn)
	{
		this.isOn = isOn;

		setChanged();
	    // notify el has changed
	    notifyObservers();	

	}
	*/
	
	abstract public String[] getIcon();
	
	
}