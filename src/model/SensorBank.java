package model;

import java.util.*;


public class SensorBank extends Observable{
	//private Map<String, Sensor> idSensorMap = new HashMap<String, Sensor>();
	private Map<SensorGroup, Sensor[] > groupSensorMap = new HashMap<SensorGroup, Sensor[]>();
	
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
	

	}
	
	public Sensor[] getGroup(SensorGroup group)
	{
		return groupSensorMap.get(group);
	}
	public void insertSensor(Sensor sensor, SensorGroup sensorGroup, int position)
	{
		Sensor[] sensorArray = groupSensorMap.get(sensorGroup);
		sensorArray[position] = sensor;
		//idSensorMap.put(sensor.getSensorID(),sensor);
	}
	public boolean checkInstalledOrNot(SensorGroup group, int position)
	{
		Sensor[] sensorArray = groupSensorMap.get(group);
		return sensorArray[position] != null;
	}

	/*public static void main(String args[])
	{
		Sensor testSensor = new Sensor();
		SensorBank bank = new SensorBank();
		bank.insertSensor(testSensor, SensorGroup.NORTH, 1);

		System.out.println(bank.getGroup(SensorGroup.NORTH));
	}
	*/

	
}
