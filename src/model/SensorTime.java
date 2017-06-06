package model;

import java.lang.*;


public class SensorTime
{
	int hour;
	int min;
	public SensorTime(int hour, int min)
	{
		this.hour = hour;
		this.min = min;
	}
	public SensorTime(String time)
	{
		String[] parts = time.split(":");
		if(parts.length != 2)
			throw new TimeFormatException(" Invalid Time! ");

	
		String part1 = parts[0];
		String part2 = parts[1];

		

		hour = Integer.parseInt(part1);
		min = Integer.parseInt(part2);


		if(hour > 23)
			throw new TimeFormatException(" Hour out of range ! ");
		if(min > 60)
			throw new TimeFormatException(" Minite out of range ! ");


	}
	
	public int compareTo(SensorTime time2){
		if(this.hour>time2.hour)
			return 1;
		if(this.hour<time2.hour)
			return -1;
		if(this.hour ==time2.hour){
			if (this.min>time2.min)
				return 1;
			else if (this.min < time2.min)
				return -1;
		}
		return 0;
	}

			
}