package model;

import java.util.*;


public class SensorBank extends Observable{

	//private Map<String, Sensor> idSensorMap = new HashMap<String, Sensor>();
	private Map<SensorGroup, Sensor[] > groupSensorMap = new HashMap<SensorGroup, Sensor[]>();
	private PassWordData pw;
	public Boolean automation;
	//private Map<SensorGroup, int[]> firesensorID;
	//private Map<SensorGroup,int[]> intrudersensorID;
	
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
		pw = new PassWordData();
		automation = false;
	
	}
	
	public Sensor[] getGroup(SensorGroup group)
	{
		return groupSensorMap.get(group);
	}
	
	public void insertSensor(Sensor sensor, SensorGroup sensorGroup, int position)
	{
		System.out.println("add sensor");
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
