package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

public class SensorSchedule
{
	HashMap< SensorGroup, ArrayList<TimeRange >> groupScheduleMap = new HashMap<SensorGroup, ArrayList<TimeRange> >();

	public SensorSchedule()
	{
		// ArrayList store the multiple TimeRanges, like 1:00-2:00 then 5:00 to 7:00
		ArrayList<TimeRange> northSchedule = new ArrayList<TimeRange>();
		ArrayList<TimeRange> southSchedule = new ArrayList<TimeRange>();
		ArrayList<TimeRange> eastSchedule = new ArrayList<TimeRange>();
		ArrayList<TimeRange> westSchedule = new ArrayList<TimeRange>();
		
	    TimeRange NorthTR = new TimeRange(new SensorTime(22,00),new SensorTime(22,01));
	    northSchedule.add(NorthTR);
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
		System.out.println(groupScheduleMap.get(SensorGroup.NORTH));
		ArrayList<TimeRange> timeArray = groupScheduleMap.get(group);
		timeArray.add(new TimeRange(startTime, endTime));
		System.out.println(groupScheduleMap.get(SensorGroup.NORTH));




	}

	
}
