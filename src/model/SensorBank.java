package model;

import java.util.*;
import java.io.*;
	
// SensorBank record the sensor information on each group: north,south,east and west
public class SensorBank extends Observable{

	private Map<SensorGroup, Sensor[] > groupSensorMap = new HashMap<SensorGroup, Sensor[]>();
	private PassWordData pw;
	public Boolean automation;
	
	//initiate each group
	public SensorBank()
	{
		Sensor[] northGroup = new Sensor[3];
		Sensor[] southGroup = new Sensor[3];
 		Sensor[] eastGroup = new Sensor[3];
		Sensor[] westGroup = new Sensor[3];
		groupSensorMap.put(SensorGroup.NORTH, northGroup);
		groupSensorMap.put(SensorGroup.SOUTH, southGroup);
		groupSensorMap.put(SensorGroup.EAST, eastGroup);
		groupSensorMap.put(SensorGroup.WEST, westGroup);
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("password.txt"));  
			pw = (PassWordData)in.readObject();  
			in.close();  
		} catch(Exception e) {
			pw = new PassWordData();
		}
		automation = false; // default automation is off, so all sensor is manually controlled
	
	}
	
	// get the Sensor Array of one SensorGroup
	public Sensor[] getGroup(SensorGroup group)
	{
		return groupSensorMap.get(group);
	}
	
	// insert sensor to a sensorGroup based on position, notify observer
	public void insertSensor(Sensor sensor, SensorGroup sensorGroup, int position)
	{
		Sensor[] sensorArray = groupSensorMap.get(sensorGroup);
		sensorArray[position] = sensor;
		setChanged();
	    // notify Observers that model has changed
	    notifyObservers();	
	}
	
	public boolean checkInstalledOrNot(SensorGroup group, int position){
		
		Sensor[] sensorArray = groupSensorMap.get(group);
		return sensorArray[position] != null;
	}
	
	public PassWordData getPassWordData(){
		return pw;
	}

	public Boolean getAutomation() 
	{
		return automation;
	}
	public void setAutomation(boolean auto)
	{
		automation = auto;
	}
	
	// if Automation of SensorBank change, the Automation of all sensors in SensorBank need to do the same change
	public void updateSensorAutomation(){
		SensorGroup[] sg = SensorGroup.values();
		for(int i=0; i<sg.length;i++){
			Sensor [] sensorArray = groupSensorMap.get(sg[i]);
			for(int j=0;j<sensorArray.length;j++){
				if(checkInstalledOrNot(sg[i],j)){
					sensorArray[j].setAutomation(getAutomation());
				}
			}
		}
	}
	
}
