package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorBank
{
	private Map<String, Sensor> idSensorMap = new HashMap<String, Sensor>();
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
	
	Sensor[] getGroup(SensorGroup group)
	{
		return groupSensorMap.get(group);
	}
	void insertSensor(Sensor sensor, SensorGroup sensorGroup, int position)
	{
		Sensor[] sensorArray = groupSensorMap.get(sensorGroup);
		sensorArray[position] = sensor;
		idSensorMap.put(sensor.getSensorID(),sensor);
	}
	boolean checkInstalledOrNot(SensorGroup group, int position)
	{
		Sensor[] sensorArray = groupSensorMap.get(group);
		return sensorArray[position] != null;
	}

	public static void main(String args[])
	{
		Sensor testSensor = new Sensor("T1");
		SensorBank bank = new SensorBank();
		bank.insertSensor(testSensor, SensorGroup.NORTH, 1);

		System.out.println(bank.getGroup(SensorGroup.NORTH));
	}
		


	
}