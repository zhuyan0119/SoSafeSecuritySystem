package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorBank
{
	private Map<String, Sensor> idSensorMap = new HashMap<String, Sensor>();
	private Map<SensorGroup, List<Sensor>> groupSensorMap = new HashMap<SensorGroup, List<Sensor>>();
	
	public SensorBank()
	{
		
		List<Sensor> northGroup = new ArrayList<Sensor>();
		List<Sensor> southGroup = new ArrayList<Sensor>();
 		List<Sensor> eastGroup = new ArrayList<Sensor>();
		List<Sensor> westGroup = new ArrayList<Sensor>();
		groupSensorMap.put(SensorGroup.NORTH, northGroup);
		groupSensorMap.put(SensorGroup.SOUTH, southGroup);
		groupSensorMap.put(SensorGroup.EAST, eastGroup);
		groupSensorMap.put(SensorGroup.WEST, westGroup);
	

	}
	
	List<Sensor> getGroup(SensorGroup group)
	{
		return groupSensorMap.get(group);
	}
	void sensorInsertion(Sensor sensor, SensorGroup sensorGroup )
	{
		groupSensorMap.get(sensorGroup).add(sensor);
		idSensorMap.put(sensor.getSensorID(),sensor);
	}
	public static void main(String args[])
	{
		Sensor testSensor = new Sensor("T1");
		SensorBank bank = new SensorBank();
		bank.sensorInsertion(testSensor, SensorGroup.NORTH);

		System.out.println(bank.getGroup(SensorGroup.NORTH));
	}
		


	
}