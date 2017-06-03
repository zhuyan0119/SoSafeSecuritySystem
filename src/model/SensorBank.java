package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorBank
{
	Map<String, Sensor> idSensorMap = new HashMap<String, Sensor>();
	Map<String, List<Sensor>> groupSensorMap = new HashMap<String, List<Sensor>>();
	
	List<Sensor> northGroup = new ArrayList<Sensor>();
	List<Sensor> southGroup = new ArrayList<Sensor>();
	List<Sensor> eastGroup = new ArrayList<Sensor>();
	List<Sensor> westGroup = new ArrayList<Sensor>();
	
	
	
	public SensorBank()
	{
		Sensor sensorNorth1 = new Sensor("N1","north");
		Sensor sensorNorth2 = new Sensor("N2","north");
		Sensor sensorNorth3 = new Sensor("N3","north");
		northGroup.add(sensorNorth1);
		northGroup.add(sensorNorth2);
		northGroup.add(sensorNorth3);
		groupSensorMap.put("north", northGroup);

		Sensor sensorSouth1 = new Sensor("S1","south");
		Sensor sensorSouth2 = new Sensor("S2","south");
		Sensor sensorSouth3 = new Sensor("S3","south");
		southGroup.add(sensorSouth1);
		southGroup.add(sensorSouth2);
		southGroup.add(sensorSouth3);
		groupSensorMap.put("south", southGroup);

		Sensor sensorEast1 = new Sensor("E1","east");
		Sensor sensorEast2 = new Sensor("E2","east");
		eastGroup.add(sensorEast1);
		eastGroup.add(sensorEast2);
		groupSensorMap.put("east", eastGroup);

		Sensor sensorWest1 = new Sensor("W1","west");
		Sensor sensorWest2 = new Sensor("W2","west");
		westGroup.add(sensorWest1);
		westGroup.add(sensorWest2);
		groupSensorMap.put("west", westGroup);

		idSensorMap.put("N1",sensorNorth1);
		idSensorMap.put("N2",sensorNorth2);
		idSensorMap.put("N3",sensorNorth3);
		idSensorMap.put("S1",sensorSouth1);
		idSensorMap.put("S2",sensorSouth2);
		idSensorMap.put("S3",sensorSouth3);
		idSensorMap.put("E1",sensorEast1);
		idSensorMap.put("E2",sensorEast2);
		idSensorMap.put("W1",sensorWest1);
		idSensorMap.put("W2",sensorWest2);


	}
}