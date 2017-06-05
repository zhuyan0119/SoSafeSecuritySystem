package model;

import java.util.*;

public class TimeRange
{
	SensorTime startTime;
	SensorTime endTime;

	public TimeRange(SensorTime startTime, SensorTime endTime)
	{
		this.startTime = startTime;
		this.endTime = endTime;
	}
}