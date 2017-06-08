package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

public class SensorSchedule extends Observable
{
	HashMap< SensorGroup, ArrayList<TimeRange >> groupScheduleMap = new HashMap<SensorGroup, ArrayList<TimeRange> >();

	public SensorSchedule()
	{
		// ArrayList store the multiple TimeRanges, like 1:00-2:00 then 5:00 to 7:00
		ArrayList<TimeRange> northSchedule = new ArrayList<TimeRange>();
		ArrayList<TimeRange> southSchedule = new ArrayList<TimeRange>();
		ArrayList<TimeRange> eastSchedule = new ArrayList<TimeRange>();
		ArrayList<TimeRange> westSchedule = new ArrayList<TimeRange>();
		groupScheduleMap.put(SensorGroup.NORTH, northSchedule);
		groupScheduleMap.put(SensorGroup.SOUTH, southSchedule);
		groupScheduleMap.put(SensorGroup.EAST, eastSchedule);
		groupScheduleMap.put(SensorGroup.WEST, westSchedule);

	}

	public ArrayList<TimeRange> getGroup(SensorGroup group)
	{
		return groupScheduleMap.get(group);
	}
	public void insertTimeRange(SensorGroup group, SensorTime startTime, SensorTime endTime)
	{
		ArrayList<TimeRange> timeArray = groupScheduleMap.get(group);
		timeArray.add(new TimeRange(startTime, endTime));

		setChanged(); 
		notifyObservers();

	}

	
}
