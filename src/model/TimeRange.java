package model;

import java.util.*;

public class TimeRange
{
	public SensorTime startTime;
	public SensorTime endTime;

	public TimeRange(SensorTime startTime, SensorTime endTime)
	{
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public String toString()
	{
		 String timeRangeString = String.valueOf(startTime.hour) + ":" + String.valueOf(startTime.min) + "-" + String.valueOf(endTime.hour) + ":" + String.valueOf(endTime.min);
		 return timeRangeString;
	}
	
}