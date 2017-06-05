package model;

public class SensorTime
{
	int hour;
	int min;
	public SensorTime(int hour, int min)
	{
		this.hour = hour;
		this.min = min;
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