package model;

import java.util.*;


public class SensorBank extends Observable{
	
	private Map<String, Sensor> idSensorMap = new HashMap<String, Sensor>();
	private Map<SensorGroup, Sensor[] > groupSensorMap = new HashMap<SensorGroup, Sensor[]>();
	
	public SensorBank()
	{
		
		
		//Sensor[] northGroup = new Sensor[3];
		Sensor[] southGroup = new Sensor[3];
 		Sensor[] eastGroup = new Sensor[3];
		Sensor[] westGroup = new Sensor[3];

		
		FireSensor firesensor1 = new FireSensor ("fireN1");
		FireSensor firesensor2 = new FireSensor("fireN2");
		IntruderSensor intrudersensor1 = new IntruderSensor("intruderN3");
		Sensor[] northGroup = {firesensor1,firesensor2,intrudersensor1};
		southGroup = northGroup;
		eastGroup = northGroup;
		westGroup = northGroup;
		
		
		
		groupSensorMap.put(SensorGroup.NORTH, northGroup);
		groupSensorMap.put(SensorGroup.SOUTH, southGroup);
		groupSensorMap.put(SensorGroup.EAST, eastGroup);
		groupSensorMap.put(SensorGroup.WEST, westGroup);
	

	}
	
	public Sensor[] getGroup(SensorGroup sensorgroup)
	{
		return groupSensorMap.get(sensorgroup);
	}
	
	//insert new sensor in one sensorgroup at particular position, we default only 3 positions in each North, South,East and West location
	void insertSensor(Sensor sensor, SensorGroup sensorGroup, int position)
	{
		Sensor[] sensorArray = groupSensorMap.get(sensorGroup);
		sensorArray[position] = sensor;
		idSensorMap.put(sensor.getSensorID(),sensor);
		groupSensorMap.put(sensorGroup, sensorArray);
	}
	public boolean checkInstalledOrNot(SensorGroup group, int position)
	{
		Sensor[] sensorArray = groupSensorMap.get(group);
		return sensorArray[position] != null;
	}
	

	


	
}
